boolean check = false;
while (rs2.next()) {
    String aa = rs2.getString("employe_id");
    if (aa.contains(UN.getText())) {
        this.aa = aa;
        check = true;//if the value exist change the variable to true
        break;       //and break the loop
    }
}

//when you end you have to check the value, if true then the user exist else no
if (check) {
    JOptionPane.showMessageDialog(null, "Exists");
} else {
    JOptionPane.showMessageDialog(null, "Username doesn't Exist");
}