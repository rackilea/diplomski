@Test
public void testdataProcessor() throws JsonParseException, JSONException {
    jsonObject.put("field","recipe_name");
    jsonObject.put("type","string");
    jsonArray.put(jsonObject);
    when(schemaParsor.parseDebeziumSchema(json)).thenReturn(jsonArray); //stub parseDebeziumSchema

    dataHandler.dataProcessor(json, topic_name, partition);

    verify(schemaParsor, times(1)).parseDebeziumSchema(json); //verify that parseDebeziumSchema is called exactly once
}