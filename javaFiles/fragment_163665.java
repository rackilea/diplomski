public class Nashorn {
    public static void main(String[] args) throws ScriptException {
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        Map<String, Object> map = new HashMap<>();
        map.put("a", 10);
        map.put("b", 20);

        try (GlobalMap globals = new GlobalMap(map)) {
            engine.eval("c = a + b; a += b;", globals);
        }

        System.out.println("map = " + map);
    }
}