public void charEdit(Checkbox chara,String account,String password){
    chara.setLabel(showInputDialog("Character Name?"));
    account=(showInputDialog("Account Name?"));
    password=(showInputDialog("Account Password?"));
    chara.setEnabled(true);
}