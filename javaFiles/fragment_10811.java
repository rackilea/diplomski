public static void main(String[] args) throws Exception {
    ScriptEngineManager factory = new ScriptEngineManager();
    ScriptEngine engine = factory.getEngineByName("JavaScript");

    //pass in the string containing the operation, for example:
    double multiplication = (double) engine.eval(args[0]); 
}