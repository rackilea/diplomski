#!/bin/bash

searchterm=$1

handleFile()
{
    f=$1
    found=`jar tf "$f"|grep "$searchterm"`
    if [ "$found" ]; then
        echo "-----------------"
        echo "$f"
        echo "-----------------"
        echo "$found"
    fi
}

ls *.?ar|while read f; do handleFile $f; done