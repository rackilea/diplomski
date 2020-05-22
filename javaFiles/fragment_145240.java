#!/bin/sh
echo Starting Jarvis Program D.
cd "`dirname \"$0\"`"
export ALICE_HOME=.
export SERVLET_LIB=lib/servlet.jar
export ALICE_LIB=lib/aliceserver.jar
export JS_LIB=lib/js.jar

# Set SQL_LIB to the location of your database driver.
export SQL_LIB=lib/mysql_comp.jar

# These are for Jetty; you will want to change these if you are using a different http server.
export HTTP_SERVER_LIBS=lib/org.mortbay.jetty.jar

export PROGRAMD_CLASSPATH=$SERVLET_LIB:$ALICE_LIB:$JS_LIB:$SQL_LIB:$HTTP_SERVER_LIBS
exec java -classpath $PROGRAMD_CLASSPATH -Xms64m -Xmx128m org.alicebot.server.net.AliceServer $1