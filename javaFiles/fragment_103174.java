PUT /agg_index
{
  "mappings": {
    "my_type": {
      "properties": {
        "time": {
          "type": "date",
          "format": "HH:mm"
        },
        "child_tag": {
          "type": "nested"
        },
        "master_tag": {
          "type": "nested"
        }
      }
    }
  }
}