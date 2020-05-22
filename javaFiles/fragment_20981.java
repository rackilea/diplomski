#!/usr/bin/csh

if $?CLASSPATH then
  setenv CLASSPATH ${CLASSPATH}:/user/Documents/Antlr4/bin/antlr-4.2.2-complete.jar
else
  setenv CLASSPATH /user/Documents/Antlr4/bin/antlr-4.2.2-complete.jar
endif
echo $CLASSPATH