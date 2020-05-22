public class Controller {
    private final Script script;
    public Controller() {
        script = new Script(this);
    }
    public Script getScript() { 
        return script; 
    }
    ...
}

public class Script {
    private final Controller controller;
    public Script(Controller c) {
        controller = c;
    }
    ...
}