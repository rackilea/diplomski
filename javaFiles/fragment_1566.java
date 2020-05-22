POST test-191220/_doc
{
  "address": "123-456, City, Country",
  "phone": "123-456-789",
  "name": "John Doe"
}

POST test-191220/_search
{
  "query": {
    "query_string": {
      "query": "*123*",
      "fields": ["address"]
    }
  }
}