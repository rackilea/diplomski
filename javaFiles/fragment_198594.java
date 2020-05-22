[snikolaev@dev01 ~]$ cat sphinx_49576229.conf
source min
{
    type = mysql
    sql_host = localhost
    sql_user = root
    sql_pass =
    sql_db = test
    sql_query = select  p.id,  p.title, p.description, l.Latitude, l.Longitude FROM post p join location l on l.id = p.location_id
    sql_attr_multi = uint post_category_id from query; SELECT post_id, id from post_category
    sql_attr_float = Latitude
    sql_attr_float = Longitude
}

index idx_min
{
    path = idx_min
    source = min
    min_prefix_len = 3
}

searchd
{
    listen                       = 9314:mysql41
        log = sphinx_min.log
        pid_file = sphinx_min.pid
    binlog_path = binlog
}