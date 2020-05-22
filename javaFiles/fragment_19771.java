public class JPassword {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        final JPasswordField field = new JPasswordField();

        field.addFocusListener(new FocusListener() {

            @Override
            public void focusLost(FocusEvent arg0) {

                char c = 0;
                field.setEchoChar(c);
                field.setText("Enter PW");

            }

            @Override
            public void focusGained(FocusEvent arg0) {

                char c = 1;
                field.setEchoChar(c);
                            field.setText("");
            }
        });

        char c = 0;
        field.setText("Enter PW");
        field.setEchoChar(c);

        frame.setLayout(new FlowLayout());
        frame.getContentPane().add(new JButton("test"));
        frame.getContentPane().add(field);
        frame.pack();
        frame.setVisible(true);
    }
}