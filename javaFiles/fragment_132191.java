{
  "query": {
    "ids": {
      "values": [
        "123"
      ]
    }
  },
  "post_filter": {
    "nested": {
      "filter": {
        "nested": {
          "path": "details.view",
          "filter": {
            "term": {
              "details.views.id": "def"
            }
          }
        }
      },
      "path": "details"
    }
  }
}