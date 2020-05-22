addButton.addActionListener(new ActionListener() {
     public void actionPerformed(ActionEvent e) {
        String text1 = field1.getText().trim();
        String text2 = field2.getText().trim();

        if (text1.isEmpty() || text2.isEmpty()) {
           // data not entered... so return the method and do nothing
           return;
        }

        // if we've reached this point, the user has entered in text and so we handle it