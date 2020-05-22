for(int n=0; n < fieldMap.length(); n++){
     JSONObject object = fieldMap.getJSONObject(n);             
     String type = object.getString("type");
     String name = object.getString("name");

     if (n != 0) {
         createTable.append(",");
     }
     createTable.append(name + " ");
     createTable.append(type);
}