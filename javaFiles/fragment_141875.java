public class TxtKeyVerifier {

    public static void main(String[] args) throws FileNotFoundException {

    Scanner keyboard = new Scanner(System.in);
    JFileChooser fileChooser = new JFileChooser(".");
    fileChooser.showOpenDialog(null);
    File keyfile = fileChooser.getSelectedFile();

        Scanner sc = new Scanner(keyfile);
        String input = sc.nextLine();

        if (authenticate1(input )) {

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
        sc.close();
        keyboard.close();
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