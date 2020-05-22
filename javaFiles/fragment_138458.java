http://localhost:9200/_ingest/pipeline/my_pipeline

{
  "my_pipeline": {
    "description": "Extract attachment information",
    "processors": [
      {
        "foreach": {
          "field": "my_field",
          "processor": {
            "attachment": {
              "field": "_ingest._value.my_base64_field",
              "target_field": "_ingest._value.my_base64_field",
              "ignore_missing": true,
              "indexed_chars": -1
            }
          }
        }
      }
    ]
  }
}