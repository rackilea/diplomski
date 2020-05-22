{
  "mappings": {
    "<mapping_name>": {
      "properties": {
        ...                   <-- Other fields like id, title, etc go here
        "subCategories": {
          "type": "nested",   <-- This is important. This is missing in your current mapping definition
          "properties": {
            "id": {
              "type":"integer"
            },
            "name": {
              "type":"string"
            },
            ...               <-- Definition of subCategoryGroup goes here
          }
        }
      }
    }
  }
}