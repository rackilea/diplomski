curl -XPOST localhost:9200/kodcucom/article/1 -d '{
   "content": "elasticsearch",
   "completion_suggest": {
     "input": [ "es", "elastic", "elasticsearch" ],
     "output": "ElasticSearch"
   }
}'