curl localhost:9200/inventory/_search?pretty=true -d '
{
  "fields" : ["models.series"],
  "query" : {
     "match" : {"name" : "cool"}
  }
}'