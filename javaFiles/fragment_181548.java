private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {
        File files = new File("c:\\"+txt1.getText()+"\\"+txt2.getText());
        if (!files.exists()) {
            if (files.mkdirs()) {

            } else {
            }
        }
    }