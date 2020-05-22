{
  "type": "record",
  "name": "MyRecord",
  "fields" : [
    {"name": "userId", "type": "long"},              // mandatory field
    {"name": "userName", "type": ["null", "string"]} // optional field 
  ]
}