GET /my_index/table_name/_search
{
    "query": {
        "prefix": {
            "field_name": "a"
        }
    }
}