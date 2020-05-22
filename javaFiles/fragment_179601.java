#!/bin/bash
#
# A wrapper for calling Javac from Cygwin
# Original Author: Igor Pechtchanski <pechtcha@cs.nyu.edu
# Modified by Florian Gattung <fgattung@gmail.com> for msgfmt compatibility
#
ME="`basename $0`"
JAVAC_EXEC="/cygdrive/%JAVA_HOME%/bin/javac.exe"
ARGS=""
#
while [ -n "$1" ]; do
   arg="$1"
   shift
   if [ -d $arg ]; then
         arg="`cygpath -p -w "$arg"`"
   fi
   if [ -f $arg ]; then
         arg="`cygpath -p -w "$arg"`"
   fi
   ARGS="$ARGS '$arg'"
done

eval "set -- $ARGS"
exec "$JAVAC_EXEC" "$@"