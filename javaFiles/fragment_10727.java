MAVEN_CLIENT_CERT=<PATH.TO.CLIENT.CERTIFICATE>

export KEYRING_NAME="login"
export KEYRING_ID=<KEYRING.ID>

# Try to get secret from the gnome keyring 
export SECRET=$(python <<END
import sys, os
# Test for gtk
try:
  import gtk #ensure that the application name is correctly set
  import gnomekeyring as gk
except ImportError:
  gtk = None
if gtk:
  id = os.environ.get("KEYRING_ID", None)
  name = os.environ.get("KEYRING_NAME", None)
  try:
    if id:
      info = gk.item_get_info_sync(name, int(id))
      attr = gk.item_get_attributes_sync(name, int(id))
      sys.stdout.write(str(info.get_secret()))
    else:
      params = {}
      types = {'secret': gk.ITEM_GENERIC_SECRET, 'network': gk.ITEM_NETWORK_PASSWORD, 'note': gk.ITEM_NOTE}
      eparams = os.environ.get("KEYRING_PARAMS", None)
      etype = os.environ.get("KEYRING_ITEMTYPE", None)
      if eparams and etype:
        list = eparams.split(',')
        for i in list:
          if i:
            k, v = i.split('=', 1)
            if v.isdigit():
              params[k] = int(v)
            else:
              params[k] = v
        matches = gk.find_items_sync(types[etype], params)
        # Write 1st out and break out of loop. 
        # TODO: Handle more then one secret.
        for match in matches:
          sys.stdout.write(str(match.secret))
          break
    sys.exit(0)
  except gk.Error:
    pass
sys.exit(1)
END
)

TMPDIR=/dev/shm
TMPTMPL=mvn-$(id -u)-XXXXXXXXXX
PASSPHRASE=$(openssl rand -base64 32)
export PASSPHRASE TMPDIR

pemfile=$(mktemp $TMPDIR/$TMPTMPL)
openssl pkcs12 -in $MAVEN_CLIENT_CERT -passin env:SECRET -out $pemfile -passout env:PASSPHRASE
p12file=$(mktemp $TMPDIR/$TMPTMPL)
openssl pkcs12 -export -in $pemfile -out $p12file -passin env:PASSPHRASE -passout env:PASSPHRASE

sh -c "while kill -0 $$ 2>/dev/null; do sleep 1; done; rm -f $pemfile; rm -f $p12file;" &

MAVEN_OPTS="$MAVEN_OPTS -Djavax.net.ssl.keyStore=$p12file -Djavax.net.ssl.keyStoreType=pkcs12 -Djavax.net.ssl.keyStorePassword=$PASSPHRASE"