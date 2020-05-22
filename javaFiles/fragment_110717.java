public class Test {
private static String password;
private static List<String> passwordList;

public static void main(String[] args) throws PrinterException {

    keyEvents ke = new keyEvents();
    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize = ((int) tk.getScreenSize().getWidth());
    int ySize = ((int) tk.getScreenSize().getHeight());

    JFrame screen = new JFrame("INSERT TITLE HERE");

    screen.setSize(xSize, ySize);
    screen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    screen.setResizable(false);

    screen.setVisible(true);

    JWindow window = new JWindow(screen);
    window.setSize(xSize, ySize);
    window.setName("INSERT TITLE HERE");

    final JTextArea text = new JTextArea();
    text.setText("Type the password > ");
    text.setBackground(Color.BLACK);
    text.setForeground(Color.green);

    passwordList = new ArrayList<String>();

    text.addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            String[] content = text.getText().split("\n");
            String newContent = "";

            for (int i = 0; i < content.length; i++) {
                if (content[i].contains("Type the password > ")) {
                    password = content[i].replace("Type the password > ", "");

                    if(password.length() > 0){
                        passwordList.add(password.substring(password.length() - 1));
                    }

                    content[i] = "Type the password > " + passwordMasked(password);


                }

                newContent += content[i];
            }

            if (evt.getKeyCode() == 10) {
                newContent += "\nYour password is " + Arrays.toString(passwordList.toArray());
            }

            text.setText(newContent);
        }
    });

    window.add(text);
    window.setVisible(true);

}

public static String passwordMasked(String password) {
    String value = password;
    password = "";
    for (char c : value.toCharArray()) {
        password += "*";
    }

    return password;
}