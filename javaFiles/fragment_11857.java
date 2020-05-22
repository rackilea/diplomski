public class ManoUserInfo implements UserInfo {

String passwd;

public void setPassword(String pass) {
    passwd = pass;
}

@Override
public String getPassphrase() {
    return null;
}

public String getPassword() {
    return passwd;
}

public boolean promptPassword(String arg0) {
    return true;

}

public boolean promptPassphrase(String arg0) {
    return true;
}
//this method responsible for that message, so just make it return true
public boolean promptYesNo(String arg0) {
  //  Object[] options = {"yes", "no"};
  /*  int foo = JOptionPane.showOptionDialog(null,
            arg0,
            "Warning",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.WARNING_MESSAGE,
            null, options, options[0]);*/
    return true;
}

public void showMessage(String message) {
    JOptionPane.showMessageDialog(null, message);
}