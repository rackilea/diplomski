curl -XGET 'http://127.0.0.1:9200/test/products/_search?pretty=1'  -d '
{
   "query" : {
      "nested" : {
         "query" : {
            "custom_score" : {
               "script" : "doc[\u0027locations.order\u0027].value",
               "query" : {
                  "constant_score" : {
                     "filter" : {
                        "and" : [
                           {
                              "term" : {
                                 "category" : 5322605
                              }
                           },
                           {
                              "term" : {
                                 "subCategory" : 6032961
                              }
                           }
                        ]
                     }
                  }
               }
            }
         },
         "score_mode" : "max",
         "path" : "locations"
      }
   }
}
'