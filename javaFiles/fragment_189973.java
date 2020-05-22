PUT documents
{
  "settings": {
    "number_of_replicas": 0,
    "number_of_shards": 1
  },
  "mappings": {
    "document": {
      "properties": {
        "title": {
          "type": "text",
          "store": true
        },
        "description": {
          "type": "text"
        }
      }
    }
  }
}

PUT documents/document/_bulk
{"index": {}}
{"title": "help me", "description": "description of help me"}
{"index": {}}
{"title": "help me two", "description": "another description of help me"}

GET documents/_search
{
  "query": {
    "match": {
      "title": "help"
    }
  },
  "stored_fields": ["title"],
  "_source": {
    "includes": ["description"]
  }
}