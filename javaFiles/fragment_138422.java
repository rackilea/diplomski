curl -XPUT localhost:9200/yourindexname -d 
'{
   "mappings":
   {
    "tags":
      {
       "properties":
         {
          "tags":
            {
             "type":"string",
             "index":"not_analyzed"
            }
          }
        }
    }
}'