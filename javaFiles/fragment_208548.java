#!/bin/bash
# this is run_app.sh. It should be able to be run stand-alone or called from another script

this_script_name="run_app.sh"

if [ "$0" == "./${this_script_name}" ] then
   java -cp . -jar blah.jar  
else
   nohup java -cp . -jar blah.jar 2>&1 &