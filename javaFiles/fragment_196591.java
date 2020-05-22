for (int i = 0; i < jsonArray.length(); i++) {
     JsonValue j = jsonArray.get(i); 
     if(j.getString("identifier").equals("erer")) {
        JsonValue tmp = jsonArray.get(0);
        jsonArray.set(0, j);
        jsonArray.set(i, tmp);
        break;
     }
}