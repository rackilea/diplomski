"query": {
    "bool": {
        "must": [
           {
               "query_string": {
                  "default_field": "thread_name",
                  "query": "apple"
               }
           },
           {
               "query_string": {
                  "default_field": "site_name",
                  "query": "test_site"
               }

           }
        ]
    }
  }