{
  "query": {
    "bool": {
      "should": [
        {
          "match": {
            "text": "section 114 penal code"
          }
        },
        {
          "match": {
            "text.raw_standard_analyzer": "section 114 penal code"
          }
        }
      ]
    }
  }
}