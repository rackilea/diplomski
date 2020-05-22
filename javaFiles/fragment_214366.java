public static void main(String[] args) throws Exception {
    ScriptEngineManager manager = new ScriptEngineManager();
    ScriptEngine engine = manager.getEngineByName("js");  
    String[] array = {"-1+3", "10-4"};

    DecimalFormat df = new DecimalFormat("#.#"); 

    StringBuilder result = new StringBuilder(array.length);
    for (int i = 0; i < array.length; i++) {            
        Object results = engine.eval(array[i]);
        System.out.println(df.format(results));
    }
}