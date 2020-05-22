private static void searchJSONObject(JSONObject obj) {
    JSONObject jobj = obj;

    Set keyset = jobj.keySet();

    for (Iterator iter2 = keyset.iterator(); iter2.hasNext();) {
        String key = (String) iter2.next();
        Object value = jobj.get(key);

        if(value instanceof JSONObject)
        {
            searchJSONObject((JSONObject)value);
        }
        else
        {
            System.out.println(key + "=" + (String)value);
        }
    }

}