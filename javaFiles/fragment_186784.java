import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class TxtKeyVerifier2 {

public static void main(String[] args) throws FileNotFoundException {

    Scanner keyboard = new Scanner(System.in);

    System.out.print("Do you to continue yes/no: ");
    String answer = keyboard.nextLine();

    switch (answer) {
    case "yes":
    case "y": {
        ChooseFile fileChooser = new ChooseFile();
        File keyfile = fileChooser.getFile();

        Scanner sc = new Scanner(keyfile);
        String input = sc.nextLine();

        if (authenticate1(input)) {

            System.out.println("This program is working if this text is found within outputfile.txt.");

            File outputfile = new File("outputfile.txt");
            FileOutputStream fos = new FileOutputStream(outputfile);
            PrintStream ps = new PrintStream(fos);
            System.setOut(ps);
            System.out.println("This program is working if this text is found within outputfile.txt.");

        } else if (authenticate2(input)) {

            System.out.println("It works.");

        } else {
            System.out.println("Error: Wrong password.");
        }
    }
        break;
    case "no":
    case "n":
        break;

    default:
        System.out.println("Invalid choice");
    }
}

private static boolean authenticate1(String password1) {

    return ((password1.length() == 6) && (password1.matches("beep11")) && (password1.matches("beep11"))
            && (password1.matches("beep11")));
}

private static boolean authenticate2(String password2) {

    return ((password2.length() == 6) && (password2.matches("beep22")) && (password2.matches("beep22"))
            && (password2.matches("beep22")));
}
}

class ChooseFile {
private JFrame frame;

public ChooseFile() {

    frame = new JFrame();
    frame.toFront();
    frame.setVisible(true);

}

public File getFile() {
    JFileChooser fc = new JFileChooser();
    if (JFileChooser.APPROVE_OPTION == fc.showOpenDialog(null)) {
        frame.setVisible(false);
        return fc.getSelectedFile();
    } else {
        System.out.println("Next time select a file.");
        System.exit(1);
    }
    return null;
}

private void BringToFront() {
    frame.setExtendedState(JFrame.ICONIFIED);
    frame.setExtendedState(JFrame.NORMAL);

}

}