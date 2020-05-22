private void createUser(int j, String reciveChat) {
    if (j == 1) {
        chatPerson1.setVisible(true);
        lbl_Chatperson1_userName.setVisible(true);
        lbl_Chatperson1_userName.setText(reciveChat);

    }else if (j == 2) {
        lbl_chatPerson2.setVisible(true);
        lbl_userName2.setVisible(true);
        lbl_userName2.setText(reciveChat);
    }else if (j == 3){
        chatPerson3.setVisible(true);
        lbl_userName3.setVisible(true);
        lbl_userName3.setText(reciveChat);}