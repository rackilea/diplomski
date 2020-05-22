#!/bin/sh
#
# my-java-app My Java App
#
# chkconfig: - 80 05
# description: Enable My Java Application
#

### BEGIN INIT INFO
# Provides:          my-java-app
# Required-Start:    $remote_fs $network
# Required-Stop:     $remote_fs $network
# Default-Start: 2 3 4 5
# Default-Stop: 0 1 6
# Description:       My Java Application
# Short-Description: Enable My Java Application
### END INIT INFO

DESC="my java app"
NAME=my-java-app
PIDFILE=/var/run/$NAME.pid
RUN_AS=ubuntu
WORK_DIR=/home/ubuntu/admin
DAEMON=/usr/bin/mvn
DAEMON_OPTS="spring-boot:run"

# Read configuration variable file if it is present
[ -r /etc/default/$NAME ] && . /etc/default/$NAME

# Load the VERBOSE setting and other rcS variables
. /lib/init/vars.sh

# Define LSB log_* functions.
# Depend on lsb-base (>= 3.2-14) to ensure that this file is present
# and status_of_proc is working.
. /lib/lsb/init-functions

do_start() {
    start-stop-daemon --start --quiet --make-pidfile --pidfile $PIDFILE \
        --background \
        --chuid $RUN_AS \
        --chdir $WORK_DIR \
        --exec $DAEMON -- $DAEMON_OPTS
}

do_stop() {
    start-stop-daemon --stop --quiet --pidfile $PIDFILE
    if [ -e $PIDFILE ]
        then rm $PIDFILE
    fi
}

case "$1" in
    start)
    echo -n "Starting $DESC: $NAME"
    do_start
    echo "."
    ;;
    stop)
    echo -n "Stopping $DESC: $NAME"
    do_stop
    echo "."
    ;;
    restart)
    echo -n "Restarting $DESC: $NAME"
    do_stop
    sleep 1
    do_start
    echo "."
    ;;
    status)
    status_of_proc -p $PIDFILE "$DAEMON" "$NAME" && exit 0 || exit $?
    ;;
    *)
    echo "usage: $NAME {start|stop|restart}"
    exit 1
    ;;
esac