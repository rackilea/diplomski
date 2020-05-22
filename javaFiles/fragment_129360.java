public static void main(String[] args) throws JSONException, FileNotFoundException, ScriptException, NoSuchMethodException {

        ScriptEngine engine= new ScriptEngineManager().getEngineByName("nashorn");

        engine.eval(new FileReader("C:\\Users\\Niku\\eclipse-workspace\\java_sample\\src\\test.js"));

        Invocable invocable = (Invocable) engine;
        Object obj = (Object)invocable.invokeFunction("fun1");
        Gson gson = new Gson();
        String k = gson.toJson(obj);
        JSONObject o = new JSONObject(k);
        System.out.println(o.getString("0"));
        System.out.println(o.getString("1"));
        System.out.println(o.getString("2"));
        System.out.println(o.getString("3"));

        Iterator x = o.keys();
        JSONArray jsonArray = new JSONArray();
        ArrayList<String> ar = new ArrayList<String>();
        while (x.hasNext()){
            String key = (String) x.next();
            ar.add(o.get(key).toString());
            jsonArray.put(o.get(key));
        }

        System.out.println(ar);
}