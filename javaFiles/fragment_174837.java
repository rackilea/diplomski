curl localhost:9200/inventory/_search?pretty=true -d '
{
  "_source" : ["models.series"],
  "query" : {
     "match" : {"name" : "cool"}
  }
}'