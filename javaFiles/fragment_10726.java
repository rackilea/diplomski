export MAVEN_CLIENT_CERT=<PATH.TO.CLIENT.CERTIFICATE>

# Retrieve secret from keychain
export SECRET=$(python <<END
from subprocess import Popen, PIPE
import re, sys, os

passlabel = os.environ.get("MAVEN_CLIENT_CERT", None)

p = Popen(['security', 'find-generic-password', '-l',passlabel,'-g'], stdout=PIPE, stderr=PIPE, stdin=PIPE)

sys.stdout.write(re.compile('password:\\s"(.*)"').match(p.stderr.read()).group(1))
sys.exit(0)
END)

TMPDIR=/tmp
TMPTMPL=mvn-$(id -u)-XXXXXXXXXX
PASSPHRASE=$(openssl rand -base64 32)
export PASSPHRASE TMPDIR

pemfile=$(mktemp $TMPDIR/$TMPTMPL)
openssl pkcs12 -in $MAVEN_CLIENT_CERT -passin env:SECRET -out $pemfile -passout env:PASSPHRASE
p12file=$(mktemp $TMPDIR/$TMPTMPL)
openssl pkcs12 -export -in $pemfile -out $p12file -passin env:PASSPHRASE -passout env:PASSPHRASE

sh -c "while kill -0 $$ 2>/dev/null; do sleep 1; done; rm -f $pemfile; rm -f $p12file;" &

MAVEN_OPTS="$MAVEN_OPTS -Djavax.net.ssl.keyStore=$p12file -Djavax.net.ssl.keyStoreType=pkcs12 -Djavax.net.ssl.keyStorePassword=$PASSPHRASE"