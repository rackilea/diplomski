protected JTextField getInputTxtField() {
    inputTxtField = null;
   {
        inputTxtField = new JTextField();
        inputTxtField.setHorizontalAlignment(SwingConstants.CENTER);
        inputTxtField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent arg0) {
                String strField = textField.getText();
                char key = arg0.getKeyChar();
                int length = strField.length();
                if (Character.toLowerCase(strField.charAt(0)) == Character.toLowerCase(key)) {
                    inputTxtField.setText(" ");
                    textField.setText(strField.substring(1));
                    System.out.println(length);
                    System.out.println(strField);
                    if (length - 1 <= 0) {
                        dispose();
                    }
                } else {
                    inputTxtField.setText(" ");
                } 
            }
        });
        inputTxtField.setBounds(56, 177, 314, 40);
        inputTxtField.setColumns(10);
    }
    return inputTxtField;
}