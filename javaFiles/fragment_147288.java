public class McGyver {

public static JDialog custPopupDialog;
public static Panel_Custom_Dialog custDial

public static void popCustomDialogTextAreaObject (String dialogTitle, String borderTitle, String inputString) {

    custDial = new Panel_Custom_Dialog(borderTitle, inputString);

    final int widthCB = 500;
    final int heightCB = 400;

    custPopupDialog = new JDialog();
    custPopupDialog.setTitle(dialogTitle);
    custPopupDialog.add(custDial);
    custPopupDialog.setSize(new Dimension(widthCB, heightCB)); /* Size(550, 450); */
    custPopupDialog.setModal(true);
    custPopupDialog.setLocationRelativeTo(null);
    custPopupDialog.setVisible(true);
  } 
  //* add a method that will return the updated string.  
  //* for this to work, Panel_Custom_Dialog should have a method that will return the updated text
  public static string getInputString()
  {
    return custDial.getInputString();  
  }
}