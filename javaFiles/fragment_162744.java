{
  "query": {
    "bool": {
      "should": [
        {
          "term": {
            "dir.raw": {
              "value": "/shared"
            }
          }
        },
        {
          "term": {
            "dir.raw": {
              "value": "/private/hitesh"
            }
          }
        },
        {
          "match_phrase_prefix": {
            "dir.raw": "/shared"
          }
        },
        {
          "match_phrase_prefix": {
            "dir.raw": "/private/hitesh"
          }
        }
      ]
    }
  }
}