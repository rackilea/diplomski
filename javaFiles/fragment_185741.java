curl -XPUT 'http://127.0.0.1:9200/test/?pretty=1'  -d '
{
   "mappings" : {
      "products" : {
         "properties" : {
            "locations" : {
               "type" : "nested",
               "properties" : {
                  "order" : {
                     "type" : "long"
                  },
                  "subCategory" : {
                     "type" : "long"
                  },
                  "category" : {
                     "type" : "long"
                  }
               }
            },
            "id" : {
               "type" : "long"
            }
         }
      }
   }
}
'