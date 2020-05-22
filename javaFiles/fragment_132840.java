public class Terminal {

public HashMap<Character, InvokesMethodItf> commands;

public Terminal() {
    this.commands = new HashMap<Character, InvokesMethodItf>();

    try {
        this.setCommand('p',
             this.getClass().getDeclaredMethod("printHelloWorld"));

    } catch (Exception e) {
        e.printStackTrace();
    }
}

public static void printHelloWorld() {// method.invoke(null) looking for "static" method
    System.out.println("Hello World!");
}


private void setCommand(char letter, Method method) {

    InvokesMethodItf inv = new InvokesMethod();

    inv.setMethod(method);

    this.commands.put(letter, inv);
}

public void executeCommand(char letter) throws Exception {
    this.commands.get(letter).invokeMethod();
 }
}