public class Result extends ScriptableObject{

    @Override
    public String getClassName() {
        // TODO Auto-generated method stub
        return "Result";
    } 
}

public class Window extends ScriptableObject { 
    private Result Result;   

    public Result getResult() {
        return Result;
    }

    @Override
    public String getClassName() {
        return "Window";
    }
}

public void call() {

    Context context = Context.enter();

    ScriptableObject scope = context.initStandardObjects();

    FileReader fileReader = new FileReader("file.js");

    Window window = new Window();

    scope.put("window", scope, window);

    scope.put("window.Result", window.getResult());

    context.evaluateReader(scope, fileReader, "test", 1, null);

    context.evaluateString(scope, "Result = window.Result;", "test", 1, null);

    context.evaluateString(scope, "var myResult = new Result();", "test", 1, null);

    context.evaluateString(scope, "r = myResult.get();", "test", 1, null);
    Object result = scope.get("r", scope);
    System.out.println("\n" + Context.toString(result));
    context.exit();

}