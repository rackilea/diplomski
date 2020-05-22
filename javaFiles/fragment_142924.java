import java.io.IOException;

import jline.TerminalFactory;
import jline.console.ConsoleReader;
import jline.console.completer.FileNameCompleter;

public class MyJLineShell {
    public static void main(String[] args) {
        try {
            ConsoleReader console = new ConsoleReader();
            console.addCompleter(new FileNameCompleter());
            console.setPrompt("prompt> ");
            String line = null;
            while ((line = console.readLine()) != null) {
                console.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                TerminalFactory.get().restore();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}