{
  "settings": {
    "analysis": {
      "filter": {
        "filter_shingle": {
          "type": "shingle",
          "max_shingle_size": 8,
          "min_shingle_size": 2,
          "output_unigrams": false
        },
        "filter_stemmer": {
          "type": "porter_stem",
          "language": "english"
        }
      },
      "analyzer": {
        "ShingleAnalyzer": {
          "tokenizer": "standard",
          "filter": [
            "lowercase",
            "snowball",
            "filter_stemmer",
            "filter_shingle"
          ]
        }
      }
    }
  },
  "mappings": {
    "test": {
      "properties": {
        "text": {
          "type": "string",
          "analyzer": "ShingleAnalyzer",
          "fields": {
            "raw_standard_analyzer": {
              "type": "string"
            }
          }
        }
      }
    }
  }
}