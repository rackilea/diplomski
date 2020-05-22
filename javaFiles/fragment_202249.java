private JLabel lblgamnt;
private Purchase purchObjName;

public Pconfirm() {
    purchObjName = new Purchase();
    purchObjName.setTextOfJLabel("The Purchase JLabel text");
    lblgamnt.setText("Pconfirm JLabel text and " + purchObjName.amount());
}