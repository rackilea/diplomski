{
  "query":{

    "where":[{

              "or":[
              {
                 "fieldName":"address1","fieldValue":"Dummy address1",

                 "operator":"equal"
              },
              {
                 "fieldName":"address1","fieldValue":"Dummy address2",

                 "operator":"$gt" // added: greater than
              },
              {
                 "fieldName":"address1","fieldValue":"Dummy address3",

                 "operator":"$ne" // added: not equal
              }

            ],
            "and":[{
                  "fieldName":"version","fieldValue":"1",

                 "operator":"equal"

             }]
           }
        ]
   }
}