JSONArray t = jsonObject.getJSONArray("MyArray");
for (int i = 0; i < t.length(); i++) {
    JSONObject temp = (JSONObject) t.get(i);
    if(temp.get("email").equals("E2")) {

        //do whatever with the object

        System.out.println(temp.get("fname"));
        System.out.println(temp.get("lname"));

        break;
    }
}