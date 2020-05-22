package blockspeak;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner keyboard = new Scanner(System.in);

        // Some initial input to let the parser have a go at.
        String input = "block A at (0, 10)   # Create block \"A\" at coordinates (0, 10)\n" +
                "block B at (0, 20)   # Create block \"B\" at coordinates (0, 20)\n" +
                "stack A on B         # Stack block A on top of block B";

        EvalBlockSpeakListener listener = new EvalBlockSpeakListener();

        // Keep asking for input until the user presses 'q'.
        while(!input.equals("q")) {

            // Create a lexer and parser for `input`.
            BlockSpeakLexer lexer = new BlockSpeakLexer(new ANTLRInputStream(input));
            BlockSpeakParser parser = new BlockSpeakParser(new CommonTokenStream(lexer));

            // Now parse the `input` and attach our listener to it. We want to reuse 
            // the same listener because it will hold out Blocks-map.
            ParseTreeWalker.DEFAULT.walk(listener, parser.parse());

            // Let's see if the user wants to continue.
            System.out.print("Type a command and press return (q to quit) $ ");
            input = keyboard.nextLine();
        }

        System.out.println("Bye!");
    }
}

// You can place this Block class inside Main.java as well.
class Block {

    final String name;
    int x;
    int y;

    Block(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    void onTopOf(Block that) {
        // TODO
    }
}