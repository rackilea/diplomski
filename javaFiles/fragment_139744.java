GET /my_index/table_name/_search
{
    "query": {
        "wildcard": {
            "field_name": "a*"
        }
    }
}