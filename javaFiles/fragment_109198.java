// writing
String xml = "<recipe name=\"bread\" prep_time=\"5 mins\"</recipe> ";
JSONObject jsonObject = JSONML.toJSONObject(string);
DocumentEntity<String> entity =     arangoDriver.createDocumentRaw(
         "testCollection", jsonObject.toString(), true, false);
String documentHandle = entity.getDocumentHandle();

// reading
String json = arangoDriver.getDocumentRaw(documentHandle, null, null);
JSONObject jsonObject2 = new JSONObject(str);
String xml2 = JSONML.toString(jsonObject2));