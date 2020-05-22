{
    "$schema": "http://json-schema.org/draft-03/hyper-schema",
    "additionalProperties": false,
    "type": "object",
    "properties": {
     "billing_address": {
           "$ref":"Address.json",
           "type": "object",
           "required": false
          },
     "shipping_address": {
           "$ref":"Address.json",
           "type": "object",
           "required": false
          }
     }
}