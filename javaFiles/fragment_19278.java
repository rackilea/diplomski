public class GetterText extends JFrame {

    JTextArea ta = new JTextArea();
    String taText;

    GetterText() {

        JButton getText = new JButton("GetText");
        getText.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                taText = ta.getText();
                System.out.println(taText);
            }
        });

        getContentPane().add(getText, BorderLayout.LINE_START);
        getContentPane().add(new JScrollPane(ta));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {

        new GetterText();
    }
}