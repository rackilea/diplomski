PUT my_index/_mapping/my_type
{
  "properties": {
    "my_field": { 
      "type":     "text",
      "fielddata": true
    }
  }
}