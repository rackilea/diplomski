{
  "_id": "_design/filters",
  "language": "javascript",
  "filters": {
    "active-doc": "function(doc, req){\n return (!doc._deleted);\n}\n"
  }
}