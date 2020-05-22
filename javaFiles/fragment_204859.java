#!/bin/sh

if [ "$1" == "-d" ] ; then
    $0 &
    exit 0
fi

PATH=/bin:/usr/bin

cd /tmp/druid-services-0.6.160/
java -Xmx256m -Duser.timezone=UTC -Dfile.encoding=UTF-8 -classpath lib/*:config/broker io.druid.cli.Main server broker