public void actionPerformed(ActionEvent event) {
    try {
        if (event.getActionCommand().equals("Submit")) {

            if (checkID() & checkName() & checkGender() & check() & checkPItem() & checkdiscount()) {
                labelRegistration.setVisible(true);
                labelError.setVisible(false);
                //concatnating the collected data to be written.
                String toBewrite = textId.getText() + "," + textName.getText();
                toBewrite = toBewrite + "," + textGender.getText() + "," + textcategory.getText();
                toBewrite = toBewrite + "," + textPItem.getText() + "," + textdiscount.getText();
                ///calling the writeToFile method where the relavent data to be updated to the file.
                writeToFile(toBewrite);
                ////
                submitButton.removeActionListener(this);
                clearButton.removeActionListener(this);
            } else {
                labelError.setVisible(true);
                labelRegistration.setVisible(false);
            }
        }
        if (event.getActionCommand().equals("Clear")) {
            textName.setText("");
            textName.setText("");
            textGender.setText("");
            textState.setText("");
            textcategory.setText("");
            textPItem.setText("");
            textdiscount.setText("");

            labelError.setVisible(false);
            labelRegistration.setVisible(false);
            labelId.setForeground(Color.BLACK);
            labelName.setForeground(Color.BLACK);
            labelGender.setForeground(Color.BLACK);
            labelcategory.setForeground(Color.BLACK);
            labelPItem.setForeground(Color.BLACK);
            labeldiscount.setForeground(Color.BLACK);

        }
        //Newly added event for Show Records button.
        if (event.getActionCommand().equals("Show Records")) {
            readFile();
        }
    } catch (Exception e) {
    }
}