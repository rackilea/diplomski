public static JSONObject convertFileToJSON(String fileName) throws ParseException {
    JSONParser parser = new JSONParser();
    JSONObject jsonObject = null;
    try {
        JSONArray array = (JSONArray) parser.parse(new FileReader(fileName));         
        jsonObject = array.getJsonObject(0);

    } catch (FileNotFoundException e) {

    } catch (IOException ioe) {

    }       
    return jsonObject;
}