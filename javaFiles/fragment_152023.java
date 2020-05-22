#!/bin/sh

MY_VAR="foobaz not exported"
echo "MY_VAR: ${MY_VAR}"
java -jar my.jar

export MY_VAR="foobaz exported"
echo "MY_VAR: ${MY_VAR}"
java -jar my.jar