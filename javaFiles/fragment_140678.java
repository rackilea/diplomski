LOAD DATA LOCAL INFILE "/tmp/myfile.txt" 
 INTO TABLE mytable
 FIELDS TERMINATED BY ' ' 
 LINES TERMINATED BY '\n'
 IGNORE 1 LINES
 ( @d1
 , @d2
 , @d3
 , @d4
 , @d5
 , @d5
 , @d6
 ) 
 SET mycol = TRIM(BOTH FROM @d4)
 ;