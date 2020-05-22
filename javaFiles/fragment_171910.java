POST <your_index>/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "match": {
            "originalName": "test"
          }
        },
        {
          "match": {
            "user.id": 1
          }
        },
        {
          "match": {
            "content": "blah"
          }
        }
      ]
    }
  }
}