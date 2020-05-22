static void printRecursive(JSONObject obj) {
    for(Object key:obj.keySet()) {

        //System.out.println(obj.get(key.toString()).getClass().getSimpleName());
        if(obj.get(key.toString()) instanceof JSONArray) {
            JSONArray aobj = ((JSONArray)obj.get(key.toString()));
            System.out.println(key.toString());
            for(int i=0;i<aobj.length();i++) {
                printRecursive(aobj.getJSONObject(i));
            }
        }
        else
        if(obj.get(key.toString()) instanceof JSONObject) {
            System.out.println(key.toString());
            printRecursive((JSONObject)obj.get(key.toString()));
        }
        else
            System.out.println(key.toString()+" -> "+obj.get(key.toString()));
    }
}