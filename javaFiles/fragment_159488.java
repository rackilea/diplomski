{
    "$schema": "http://json-schema.org/draft-03/hyper-schema",
    "additionalProperties": false,
    "javaType": "whatever-package-name-you-have.Address"
    "type": "object",
    "properties": {
    "street_address": { "type": "string", "required":true},
    "city":           { "type": "string", "required":true },
    "state":          { "type": "string", "required":true }
  }
}