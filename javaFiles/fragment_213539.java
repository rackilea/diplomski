"mappings": {
"doc": {
    "object": {
        "type": "nested",
        "properties": {
            "author": {
                "type": "text",
                "analyzer": "hebrew",
                "fields": {
                    "exact": {
                        "type": "text",
                        "analyzer": "hebrew_exact"
                    },
                    "suggest": {
                        "type": "completion",
                        "analyzer": "simple",
                        "preserve_separators": false,
                        "preserve_position_increments": true,
                        "max_input_length": 50
                    }
                }
            },
            "content": {
                "type": "text",
                "analyzer": "hebrew_exact"
            },
            "title": {
                "type": "text",
                "analyzer": "hebrew",
                "fields": {
                    "exact": {
                        "type": "text",
                        "analyzer": "hebrew_exact"
                    },
                    "suggest": {
                        "type": "completion",
                        "analyzer": "simple",
                        "preserve_separators": false,
                        "preserve_position_increments": true,
                        "max_input_length": 50
                    }
                }
            }
        }
    }
}