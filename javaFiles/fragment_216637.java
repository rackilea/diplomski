public class Foo extends JPanel {
    private JButton ask = new JButton("Ask");
    private JTextField textGive = new JTextField(10);
    private String given = "";  // visible throughout the class

    public Foo() {
        add(textGive);
        add(ask);
        ActionListener listener = e -> {
            String guess = "";
            // String given = textGive.getText(); //visible only within this method
            given = textGive.getText();
            guess = given.replaceAll("\\w", "*");
            textGive.setText(guess);
        };

        ask.addActionListener(listener);
        textGive.addActionListener(listener);  // also give the same listener to the JTextField
    }