JSONObject jsonObject = new JSONObject(response);
String theNonReadableJson = jsonObject.getString("key");

SerializedPhpParser serializedPhpParser = new SerializedPhpParser(
                        theNonReadableJson);
Object serializedObject = serializedPhpParser.parse();

JSONObject readableJson = new JSONObject(serializedObject.toString());