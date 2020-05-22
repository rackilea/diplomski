public class userFileSelected extends JFrame implements ActionListener, KeyListener {
//populate this field however you see fit
private boolean fileSelected;
//public JFrame so other classes can make modifications.
public JFrame parent = new JFrame();
public static void main(String[] args) {
String selectedFile;
selectedFile = JOptionPane.showInputDialog(parent, "Input file name");
String selectedFile1 = selectedFile;
selectedRequirement = selectedFile1;

if (fileSelected) {
   parent.setVisible(false);
}
else {
  parent.setVisible(true);
   }
}