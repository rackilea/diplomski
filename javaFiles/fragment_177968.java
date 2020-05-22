%dw 2.0
output application/json

var rootObj = {
  "definitions": {},
  "\$schema":    "http://json-schema.org/draft-07/schema#",
  "\$id":        "http://example.com/root.json",
  "type":        "object",
  "title":       "The Root Schema"
}

var props = payload.Schema reduce ((schema, acc={}) ->
  acc ++ {
    (schema.Column_Name): {
      "\$id":      "#/properties/$(schema.Column_Name)",
      "type":      schema.Type,
      "maxLength": schema.Length - 1
    }
  })
---
rootObj ++ {"properties": props}