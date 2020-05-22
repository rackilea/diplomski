HashMap<Integer,boolean[]>hashmapB_Ret = new HashMap<>();

try {
    JSONObject jsonObject = new JSONObject(hashmapB_String);
    Iterator<String> keysItr = jsonObject.keys();
    while(keysItr.hasNext()) {
          String key = keysItr.next();
          boolean[] values = (boolean[]) jsonObject.get(key);
          hashmapB_Ret.put(Integer.valueOf(key), value);
    }
 } catch (JSONException e) {
        e.printStackTrace();
 }