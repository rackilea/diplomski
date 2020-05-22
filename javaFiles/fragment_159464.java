#!/bin/sh

# Create some random file in /tmp
filename=$(head /dev/urandom | tr -dc A-Za-z0-9 | head -c 13 ; echo '')
touch /tmp/$filename
cat /tmp/$filename
export filename=$filename