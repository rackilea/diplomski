/**
 * Mediate overridden method to set the token property.
 */@Override
public boolean mediate(MessageContext context) {
try {

    // Getting the json payload to string
    String jsonPayloadToString = JsonUtil.jsonPayloadToString(((Axis2MessageContext) context)
        .getAxis2MessageContext());
    // Make a json object
    JSONObject jsonBody = new JSONObject(jsonPayloadToString);

    // Adding the name:nameParam.
    jsonBody.put("name", getNameParam());

    String transformedJson = jsonBody.toString();

    // Setting the new json payload.
    JsonUtil.newJsonPayload(
    ((Axis2MessageContext) context).getAxis2MessageContext(),
    transformedJson, true, true);

    System.out.println("Transformed JSON body:\n" + transformedJson);

} catch (Exception e) {
    System.err.println("Error occurred: " + e);
    return false;
}

return true;
}