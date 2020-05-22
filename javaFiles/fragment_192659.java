{
  "$schema": "http://json-schema.org/draft-07/schema#",
  "type": "object",
  "properties": {
    "categoryMapping": {
      "type": "array",
      "items": {
        "type": "object",
        "required": [
          "name",
          "map"
        ],
        "properties": {
          "name": {
            "type": "string"
          },
          "map": {
            "type": "array",
            "items": {
              "type": "string"
            }
          }
        }
      }
    }
  }
}