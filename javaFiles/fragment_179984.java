public class Context {
    private static Context instance = null;
    private Stack<String> variables = new Stack<>();

    private Context(){};
    public String peek() {return variables.peek();}
    public String pop() {return variables.pop();}
    public void fork() {variables.push(variables.peek());}
    public void push(String variable) {variables.push(variable);}

    public static void set(String variable) {
        if(Context.instance == null)
            Context.instance = new Context();
        Context.instance.push(variable);
    }

    public static String get() {
        if(Context.instance == null)
            throw new NullPointerException();
        return Context.instance.pop();
    }

   public static void remove() {
        if(Context.instance == null)
            throw new NullPointerException();
        Context.instance.pop();
    }

    public static void duplicate() {
        if(Context.instance == null)
            throw new NullPointerException();
        Context.instance.fork();
    }

    public static String read() {
        if(Context.instance == null)
            throw new NullPointerException();
        return Context.instance.peek();
    }
}