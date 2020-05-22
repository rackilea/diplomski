curl -XDELETE 'http://localhost:9200/test'

curl -XPOST 'http://localhost:9200/test' -d '{
    "analysis": {
       "analyzer": {
            "suffix_analyzer": {
                "filter": ["lowercase", "reverse"],
                "tokenizer": "keyword",
                "type": "custom"}
      }
   }
}'