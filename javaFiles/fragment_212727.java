private static void searchJSONArray(JSONArray arry) {
    JSONArray jarry = arry;
    JSONObject jobj = null;

    for (Iterator iter = jarry.iterator(); iter.hasNext();) {
        Object o = iter.next();
        if (o instanceof JSONArray) {
            searchJSONArray((JSONArray) o);
        } else if (o instanceof JSONObject) {
            jobj = (JSONObject) o;
            Set keyset = jobj.keySet();

            for (Iterator iter2 = keyset.iterator(); iter2.hasNext();) {
                String key = (String) iter2.next();
                Object value = jobj.get(key);

                if(value instanceof JSONObject)
                {
                    System.out.println("[" + key + "]");
                    searchJSONObject((JSONObject)value);
                }
                else
                {
                    System.out.println(key + "=" + (String)value);
                }
            }
        }

    }
}