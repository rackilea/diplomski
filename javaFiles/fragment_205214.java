private static class Class1 extends HashMap<String, Object> {
    public static class class1ToJsonAdapter {
        @ToJson
        public Map<String, Object> toJson(Class1 dat) {
            return (Map<String,Object>)dat;
        }

        @FromJson
        public Class1 fromJson(Map<String,Object> json) {
            Class1 result = new Class1();
            for (String key : json.keySet())
                result.put(key, json.get(key));
            return result;
        }
    }

    //Some Constructors and methods omitted for the test.
    //Relevant for the serilisation to JSON are only the keys and values in the map.
}