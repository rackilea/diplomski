protected void myBox(ActionEvent e) {
    Object obj = userList.getSelectedItem();
    if(obj != null) {
        if (obj instanceof User) {
            User user = (User)obj;
            pointsEarned.setText(NumberFormat.getNumberInstance().format(user.getPoints())
        }
    }
}