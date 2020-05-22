public class MyForm extends JPanel {

    private JTextField typingArea;
    private String userWord; 

    public MyForm() {

        typingArea = new JTextField();
        typingArea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userWord = typingArea.getText().toLowerCase();
                typingArea.setText("");
            }
        });
    }
}