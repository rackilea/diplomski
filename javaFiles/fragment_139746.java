GET /my_index/table_name/_search
{
    "query": {
        "match_phrase": {
            "field_name": "a"
        }
    }
}