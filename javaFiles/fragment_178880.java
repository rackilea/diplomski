btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String nums = textField.getText();

                if (nums.matches("[0-9]+") && nums.length() == 10) {

                    char[] charArray = nums.toCharArray();
                    int sum = 0;

                    for (int i = 0; i < charArray.length; i++) {
                        sum += Character.getNumericValue(charArray[i]);
                    }
                    label_1.setText(Integer.toString(sum));
                }
            }