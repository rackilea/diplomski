{
  "settings": {
    "analysis": {
      "filter": {
        "filter_word_delimiter": {
          "type": "word_delimiter"
        },
        "custom_shingle": {
          "type": "shingle",
          "token_separator":"",
          "max_shingle_size":3
        }
      },
      "analyzer": {
        "en_us": {
          "tokenizer": "keyword",
          "filter": [
            "filter_word_delimiter",
            "custom_shingle",
            "lowercase"
          ]
        }
      }
    }
  }
}