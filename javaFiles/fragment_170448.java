JFrame f = new JFrame("Demo");
    f.setLayout(new FlowLayout());
    f.setSize(300, 200);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //put the frame at the center of your monitor  
    f.setLocationRelativeTo(null); 
    JTextField userText = new JTextField(6);
    JLabel label = new JLabel();
    JButton button = new JButton("OK");


    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (label.getText().isEmpty()) {
                label.setText(userText.getText());
            }
        }
    });


    f.add(userText);
    f.add(button);
    f.add(label);
    f.setVisible(true);
}