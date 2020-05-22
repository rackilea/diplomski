{
  "query" : {
    "nested" : {
      "query" : {
        "bool" : {
          "must" : [
            {
              "match" : {
                "authorList.authorOrder" : 1
              }
            }
          ]
        }
      },
      "path" : "authorList"
    }
  },
  "sort" : [
    {
      "authorList.lastName" : {
        "order" : "asc",
        "nested_filter" : {
          "bool" : {
            "must" : [
              {
                "match" : {
                  "authorList.authorOrder" : 1
                }
              }
            ]
          }
        },
        "nested_path" : "authorList"
      }
    }
  ]
}