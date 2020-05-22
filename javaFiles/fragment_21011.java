{
"mappings" : {
  "products" : {
    "dynamic": false,
    "properties" : {
      ...
      "customer": {
          "type": "nested",
          "properties": {
              "prop a": {...},
              "prop b": {...}
          }
      },
      "vendor": {
          "type": "nested",
          "properties": {
              "prop a": {...},
              "prop b": {...}
          }
      },
      ...
    }
  }
}
}