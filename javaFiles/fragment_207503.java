$ curl -XGET 'http://localhost:9200/localhost.localdomain/SET_APPS/_search?pretty=true' -d'
{
  "size":0,
  "query" : {
    "constant_score" : {
      "filter" : {
        "range" : {
           "time" : {
             "gte" : 1457868375000,
             "lt"  : 1460460375000
           }
         }
       }
     }
   },
  "aggregations" : {
      "time_hist" : {
        "histogram" : {
          "field" : "time",
          "interval" : 10125000,
          "order" : {
            "_count" : "asc"
          },
          "min_doc_count" : 0,
          "extended_bounds" : {
            "min" : 1429010378445,
            "max" : 1431602378445
          }
        },
        "aggregations" : {
          "max_time": {
            "terms": {
              "field":"time",
              "order" : {
                "max_score": "desc"
              },
              "size":1

            },
            "aggregations":{
              "max_score" : {
                "max" : {
                  "field" : "score"
                }
              }
            }
          }
        }
      }
    }
  }
}' > foo