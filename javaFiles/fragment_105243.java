public void actionPerformed(ActionEvent e) {
            String check = phrase2.getText();

            if (check.equals("Permitido")) {
                phrase2.setText("Prohibido");

                phrase1.setForeground(Color.green);
                phrase2.setForeground(Color.green);

                getContentPane().setBackground(Color.RED);// !!