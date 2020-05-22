private void calculateButtonActionPerformed(java.awt.event.ActionEvent evt) {
    String backTrouble;
    String heartTrouble;
    int riderHeight = Integer.parseInt(inputHeight.getText());
    backTrouble = inputBack.getText();
    heartTrouble = inputHeart.getText();

    // get rid of the while loop, 
    // while ((riderHeight >= 122) && (riderHeight <= 188)){
    if ((riderHeight >= 122) && (riderHeight <= 188)){
        if ((backTrouble.equals("N")) && (heartTrouble.equals("N"))){
            responseField.setText("It is OK for you to ride this roller coaster. Have fun!");
        }
        else if ((backTrouble.equals("Y")) && (heartTrouble.equals("N"))){
            responseField.setText("Sorry, it is not safe for you to ride this roller coaster.");
        }
        else if ((backTrouble.equals("N")) && (heartTrouble.equals("Y"))){
            responseField.setText("Sorry, it is not safe for you to ride this roller coaster.");
        }
        else{
            responseField.setText("Sorry, it is not safe for you to ride this roller coaster.");
        }

        // again, no while loops here
        // while ((riderHeight < 122) || (riderHeight > 188)){
        if ((riderHeight < 122) || (riderHeight > 188)){
            responseField.setText("Sorry, it is not safe for you to ride this roller coaster.");
        }
    }
}