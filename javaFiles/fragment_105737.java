#!/bin/bash

for line in $(cat total.csv)          
do          
   filename=$(echo $line | awk -F "," '{print $2}')
   echo $line >> $filename.csv 
done