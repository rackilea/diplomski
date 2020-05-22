#!/bin/bash

if [ $# -ne 3 ]; then
    echo "You need to supply both JMX host and port and metric. Exiting ..."
    exit 1
fi

JAVA_BIN="/usr/bin/java"
JMX_CMDLINE="./cmdline-jmxclient-0.10.3.jar"
APP_NAME="${1}"

if [ $3 = "DaemonThreadCount" -o $3 = "all" ]; then

  TEMPFILE=`mktemp`
  $JAVA_BIN -jar $JMX_CMDLINE - ${1}:${2}  "java.lang:type=Threading" DaemonThreadCount 2>> $TEMPFILE
  VALUE=`grep DaemonThreadCount $TEMPFILE | sed "s/.*DaemonThreadCount: //g" | cut -f2 -d:` 
  echo "$VALUE"
  rm -f $TEMPFILE

fi

if [ $3 = "HeapMemoryUsage" -o $3 = "all" ]; then

  TEMPFILE=`mktemp`
  $JAVA_BIN -jar $JMX_CMDLINE - ${1}:${2}  "java.lang:type=Memory" HeapMemoryUsage 2>> $TEMPFILE

  OUTPUT=`cat $TEMPFILE | egrep "committed:|used:" | sed "s/: /=/g"`

  for line in $OUTPUT
  do
    NAME=`echo $line | cut -f1 -d=`
    VALUE=`echo $line | cut -f2 -d=`
  done

  cat $TEMPFILE | grep used | cut -f2 -d" "
  rm -f $TEMPFILE

fi


if [ $3 = "PSPermGen" -o $3 = "all" ]; then

  rm -f $TEMPFILE

  $JAVA_BIN -jar $JMX_CMDLINE - ${1}:${2}  "java.lang:name=PS Perm Gen,type=MemoryPool" Usage 2>> $TEMPFILE

  OUTPUT=`cat $TEMPFILE | egrep "committed:|used:" | sed "s/: /=/g"`

  for line in $OUTPUT
  do
    NAME=`echo $line | cut -f1 -d=`
    VALUE=`echo $line | cut -f2 -d=`
    echo "$VALUE"
  done

fi