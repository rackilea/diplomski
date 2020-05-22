{
  "query": {
    "query_string": {
      "query": "myfield:*"
    }
  },
  "aggs": {
    "high_low": {
      "range": {
        "field": "myfield",
        "keyed": true,
        "ranges": [
          {
            "key": "foo_low",
            "from": 1,
            "to": 6
          },
          {
            "key": "foo_high",
            "from": 6,
            "to": 11
          }
        ]
      }
    }
  }
}