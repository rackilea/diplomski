#!/bin/bash

cat<<EndBlock | at 5pm
for i in {1..5}; do
    java -jar myjar.jar "$@" &
    pid=$!
    { sleep 600 && kill $pid; } &
done
EndBlock