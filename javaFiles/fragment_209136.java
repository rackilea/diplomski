import java.awt.Color;
import enigma.console.*;
import enigma.core.Enigma;
public class Main
{
    public static void main(String[] args)
    {
        TextAttributes attrs = new TextAttributes(Color.BLUE, Color.WHITE);
        s_console.setTextAttributes(attrs);
        System.out.println("Hello World!");
    }
    private static final Console s_console;
    static
    {
        s_console = Enigma.getConsole("Hellow World!");
    }
}