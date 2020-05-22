GET _search
{
  "from": 0,
  "size": 20,
  "query": {
    "query_string": {
      "query": "test*",
      "default_field": "name"
    },
    "bool": {
      "should": [
        {
          "bool": {
            "must": [
              {
                "term": {
                  "type": "DATASOURCE"
                }
              },
              {
                "term": {
                  "category": "cat1"
                }
              },
              {
                "term": {
                  "sub_category": "subcat1"
                }
              }
            ]
          }
        },
        {
          "term": {
            "type": "FLOW"
          }
        }
      ],
      "minimum_number_should_match": 1
    }
  }
}