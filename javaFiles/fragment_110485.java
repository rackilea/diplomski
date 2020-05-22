#!/bin/sh

for ((i=0; i<3; i++))
  do
    java -jar CassandraClientReadLnP.jar config.properties NUMBER_OF_THREADS:10 TOTAL_RUNNING_TIME:30 > cassandra_read_prod_netflix_1.10.$i.txt
  done