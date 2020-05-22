String body = "Which will you choose?";
String title = "The Title";

int choice = JOptionPane.showConfirmDialog(null, body, title, JOptionPane.YES_NO_OPTION);
switch(choice) {
case JOptionPane.YES_OPTION:
    createAndDoWindowForYesOption(); break;
case JOptionPane.NO_OPTION:
    createAndDoWindowForNoOption(); break;
default:
    doNothing(); break;
}