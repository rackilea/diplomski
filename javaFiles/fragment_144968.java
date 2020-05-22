package cli;

import java.awt.EventQueue;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;

/** @see https://stackoverflow.com/q/9832252/230513 */
public class CommandLineClient {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Give me a name for the screen: ");
        final String response = in.nextLine();
        try {
            ProcessBuilder pb = new ProcessBuilder(
                "java", "-cp", "build/classes", "cli.NamedFrame", response);
            Process proc = pb.start();
        } catch (IOException ex) {
            ex.printStackTrace(System.err);
        }
    }
}

class NamedFrame extends JFrame {

    public NamedFrame(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setVisible(true);
    }

    public static void main(final String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame f = new NamedFrame(args[0]);
            }
        });
    }
}