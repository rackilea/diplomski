curl -XPUT "http://localhost:9200/test/creditcard/_mapping" -d' {
    "creditcard" : {
      "properties": {
          "cardnumber":{"type" : "string", "analyzer" : "suffix_analyzer"}
        }
    }
}'