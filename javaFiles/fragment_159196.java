public Runtime() {
    ...
    String shared = new Scanner(
        this.getClass().getClassLoader().getResourceAsStream("runtime/shared.js")
    ).useDelimiter("\\Z").next();

    try {
        ...        
        nashorn.eval(shared);
        ...
    } catch(ScriptException e) {
        ...
    }
}