{
  "query": {
    "bool": {
      "should": [
        {"wildcard": {"IP": "192.168.*.11"}},
        {"wildcard": {"IP": "192.168.*.13"}}
      ]
    }
  }
}