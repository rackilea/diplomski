} else {
    Object object = rsNew.getObject(column_name);
    if (object != null) {
      obj.put(column_name, rsNew.getObject(column_name));
    } else {
      obj.put(column_name, JSONObject.NULL);
    }
}