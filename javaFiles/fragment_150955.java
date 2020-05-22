PUT /documents
{
    "mappings" : {
        "document" : {
            "properties" : {
                "filename" : { "type" : "text", "analyzer": "simple" }
            }
        }
    }
}