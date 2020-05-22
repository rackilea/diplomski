PUT /index
{
  "settings": {
    "analysis": {
      "filter": {
        "code": {
          "type": "pattern_capture",
          "preserve_original": 1,
          "patterns": [
            "(\\p{Ll}+|\\p{Lu}\\p{Ll}+|\\p{Lu}+)",
            "(\\d+)"
          ]
        }
      },
      "analyzer": {
        "code": {
          "tokenizer": "pattern",
          "filter": [
            "code",
            "lowercase"
          ]
        }
      }
    }
  },
  "mappings": {
    "test": {
      "properties": {
        "code": {
          "type": "string",
          "analyzer": "code"
        }
      }
    }
  }
}