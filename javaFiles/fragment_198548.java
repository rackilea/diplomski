{
  "query": {
      "match_all": {}
   },
   "aggs": {
      "family": {
         "terms": {
            "field": "family"
         },
         "aggs": {
            "top_sales_hits": {
               "top_hits": {
                  "sort": [
                     {
                        "date": {
                           "order": "desc"
                        }
                     }
                  ],
                  "_source": {
                     "includes": [
                        "date",
                        "price"
                     ]
                  },
                  "size": 10
               }
            }
         }
      }
   }
}