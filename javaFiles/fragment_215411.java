curl 'http://localhost:9200/test-idx/_search?pretty=true' -d '{
    "query" : {
        "match_all" : { }
    },
    "script_fields": {
        "terms" : {
            "script": "analyze",
            "params": {
                "field": "message"
            }
        }

    }
}'