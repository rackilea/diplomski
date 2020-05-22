// Create empty JSONObect here: "{}"
JSONObject jsonObject = new JSONObject();

// Create another empty JSONObect here: "{}"
JSONObject myValueData = new JSONObject();

// Now put the 2nd JSONObject into the field "valuedata" of the first:
// { "valuedata" : {} }
jsonObject.put("valuedata", myValueData);

// And now add all your fields for your 2nd JSONObject, for example period:
// { "valuedata" : { "period" : 1} }
myValueData.put("period", 1);
// etc.