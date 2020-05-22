{
  "mappings": {
    "test": {
      "properties": {
        "my_numeric": {
          "type": "integer",
          "fields": {
            "as_string": {
              "type": "string",
              "index": "not_analyzed"
            }
          }
        }
      }
    }
  }
}