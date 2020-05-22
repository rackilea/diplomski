db.getCollection('customer').aggregate([ 
{ "$project": {
    "_id":1,
    "customerId" :1,
    "contract": {
      "$filter": {
        "input": {
          "$map": {
            "input": "$contract",
            "as": "con",
            "in": {
              "pricing": {
                "$filter": {
                 "input": {
                    "$map": {
                  "input": "$$con.pricing",
                  "as": "pric",
                   "in" : {
                     "billProfile" : {
                       "$filter" : {
                         "input" : "$$pric.billProfile",
                          "as" : "billProf",
                          "cond": {
                                "$eq": [ "$$billProf.billCode", "code5" ] 
                            }

                       }
                     }
                   }
                }
                 },
                 "as": "pric",
                  "cond": {
                    "$and": [
                      { "$gt": [ { "$size": "$$pric.billProfile" }, 0 ] }
                    ]
                  }
                }
              }             
            }
          }
       },
       "as": "con",
        "cond": {
          "$and": [
            { "$gt": [ { "$size": "$$con.pricing" }, 0 ] }
          ]
        }
      }
     }
    }
  }
]
)