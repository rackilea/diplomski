/**
   * @param malformedArrayKey
   *          - Name of the key in the JSON object that has a malformed array
   *          for e.g consider following JSON object having a bad formed array
   *          <pre>
   *      {
   *        "task": "findRecords",
   *        "foundRecords": "[1234567, 11234512]",
   *      }
   *          </pre>
   * @param jsonString
   *          - String representation of the JSON object containing the malformed array
   * @return - json string having well formed array against the key {@code malformedArrayKey} supplied
   *         <pre>
   *        {
   *        "task": "findRecords",
   *        "foundRecords": [1234567, 11234512]
   *        }
   *         </pre>
   */
  public static String formatMalformedArray(String malformedArrayKey, String jsonString) {
    JsonObject jsonObj = gson.fromJson(jsonString, JsonObject.class);
    // get the faulty key value
    String malformedArrayKeyValue = jsonObj.get(malformedArrayKey)
        .getAsString();
    // drop it
    jsonObj.remove(malformedArrayKey);
    // create a array out of the malformed array string
    JsonArray jsonArray = gson.fromJson(malformedArrayKeyValue, JsonArray.class);
    // add the array back to the object
    jsonObj.add(malformedArrayKey, jsonArray);
    // now convert it into a well formed json string
    return jsonObj.toString();
  }