#!/bin/bash
if [ -x /usr/bin/java ] ; then
        java -version 2>&1 | head -1 | awk -F '"' '{print $2}'
else
        exit
fi