public class MyJFrame extends JFrame {

MyJFrame() {
    try {
        MaskFormatter mk = null;
        try {
            mk = new MaskFormatter("**-**-**-**-**-**-**-**-**-**-**-**-**-**-**");
            mk.setPlaceholderCharacter('_');
        } catch (ParseException e) {
            e.printStackTrace();
        }
        JFormattedTextField format1 = new JFormattedTextField(mk);
        format1.setBounds(170, 80, 280, 25);
        format1.setFont(new Font("serif", Font.PLAIN, 13));
        String value = "ZZ-99-ZZ-99-ZZ-99-ZZ-99-ZZ-99-ZZ-99-ZZ-99-ZZ";//hashmap1.get("Command 1").substring(hashmap1.get("Command 1").lastIndexOf("-")+2, hashmap1.get("Command 1").length());
        String display = mk.valueToString(value);
        System.out.println("display = " + display);
        format1.setValue(value);
        add(format1);
        pack();
    } catch (ParseException ex) {
        Logger.getLogger(MyJFrame.class.getName()).log(Level.SEVERE, null, ex);
    }
}

/**
 * @param args the command line arguments
 */
public static void main(String args[]) {
    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new MyJFrame().setVisible(true);
        }
    });
}
}