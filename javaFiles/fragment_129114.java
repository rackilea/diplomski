{
  "query" : {
    "bool" : {
      "must" : [
        {
          "match_phrase" : {
            "title" : "main title"
          }
        },
        {
          "terms" : {
            "tags" : [ "first", "page" ]
          }
        }
      ]
    }
  }
}