JSONParser parser = new JSONParser();

Object parsed = parser.parse(response.toString());
JSONObject jsonObject = (JSONObject) parsed;

JSONArray jsonArray = (JSONArray) jsonObject.get("cliente");

for (Object obj : jsonArray) {
    if (obj instanceof JSONObject) {
        JSONObject cpf = (JSONObject) obj;
        System.out.println(cpf.get("cpf").toString());
    }
}