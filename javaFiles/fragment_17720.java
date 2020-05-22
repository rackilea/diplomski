{
  "query": {
    "nested": {
      "path": "subCategories",
      "query": {
        "match": {
          "subCategories.name": "subname1"
        }
      }
    }
  }
}