{
    "query": {
        "filtered": {
            "query": {
                "match_all": {}
            },
            "filter": {
                "bool": {
                    "should": [
                        { "terms": { "F1": ["Some Value"] },
                        { "missing": { "field": "F1" } }
                    ]
                }
            }
         }
     }
}