public class Example extends JFrame {

    public Example() {

        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BoxLayout(boxPanel, BoxLayout.PAGE_AXIS));

        JTextField textField = new JTextField(20);      
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                JLabel label = new JLabel(textField.getText());
                label.setOpaque(true);
                label.setBackground(Color.RED);
                boxPanel.add(label);
                boxPanel.add(Box.createRigidArea(new Dimension(0,5)));
                textField.setText("");
                boxPanel.revalidate();
//              pack();
            }
        });


        JPanel southPanel = new JPanel();
        southPanel.add(textField);
        southPanel.add(sendButton);

        add(new JScrollPane(boxPanel));
        add(southPanel, BorderLayout.PAGE_END);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {

        new Example();
    }
}