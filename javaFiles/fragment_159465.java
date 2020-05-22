$ docker run -itd --env JAVA_OPTS="$JAVA_OPTS -XX:HeapDumpPath=/mnt/crashdumps/java_$(head /dev/urandom | tr -dc A-Za-z0-9 | head -c 13 ; echo '').hprof" alpine sh
$ docker exec -it 75f062ff8906 env
PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin
HOSTNAME=75f062ff8906
TERM=xterm
JAVA_OPTS= -XX:HeapDumpPath=/mnt/crashdumps/java_MyRZcSKxFtZaF.hprof
HOME=/root