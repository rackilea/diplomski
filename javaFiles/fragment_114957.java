numberField.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            userSelection = Integer.parseInt(numberField.getText());
            con.setBackground(Color.red);

            if (userSelection == computerGenerated) {
                label1.setText("You are correct");
                con.setBackground(Color.GREEN);
            } else if (userSelection > computerGenerated) {
                label1.setText("You are too high");
            } else if (userSelection < computerGenerated) {
                label1.setText("You are too low");
            }
        }
    });