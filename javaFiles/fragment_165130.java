curl -XPUT 'localhost:9200/_river/my_jdbc_river/_meta' -d '{
    "type" : "jdbc",
    "jdbc" : {
        "driver" : "com.mysql.jdbc.Driver",
        "url" : "jdbc:mysql://localhost:3306/the_db",
        "user" : "root",
        "password" : "hunter2",
        "sql" : "select * from hamburgers",

    },
    "index" : {
        "index" : "the_db",
        "type" : "hamburgers"
    }
}'