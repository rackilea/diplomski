// likely in some constructor or method
Object[] colourchoice = {"Default", "Orange"};   
String UserInput = (String) JOptionPane.showInputDialog(null, "Please choose a colour","ColourChoice",JOptionPane.PLAIN_MESSAGE, null,colourchoice, "Default");
if (UserInput == "Orange") Panel.setBackground(Color.ORANGE);

GUIDesign window = new GUIDesign();
window.setVisible(true);
window.setSize(100, 100);
JPanel Panel = new JPanel();  // ***** here
window.setContentPane(Panel);