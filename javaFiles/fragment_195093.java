CREATE EXTERNAL TABLE table_ids(item_id int)
FIELDS TERMINATED BY '\t'
LINES TERMINATED BY '\n'
STORED AS TEXTFILE
location '/hive/data' --location(directory) in hdfs where the file is
;
select item_name from table a
      inner join table_ids b on a.item_id=b.item_id