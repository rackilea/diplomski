curl -s "localhost:9200/test/_search" -d '
{
  "query":{
    "query_string":{
      "query":"Java for beginners"
    }
  }
}'