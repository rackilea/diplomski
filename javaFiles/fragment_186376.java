public class ModalPopUp {
JPopupMenu    popUpMenu;
JMenuItem     menuItem;
static Object modalMonitor = new Object();
public void popIt(Component parent, int x, int y) {
  popUpMenu.show(parent, x, y);
}
public void stopIt() {
  popUpMenu.setVisible(false);
}
public ModalPopUp() {
popUpMenu = new JPopupMenu();
menuItem = new JMenuItem("Click me to Continue");
popUpMenu.add(menuItem);
menuItem.addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent e) {
    synchronized (modalMonitor) {
      modalMonitor.notify();
    }
  }
});
}
public static void main(String args[]) throws Exception {
ModalPopUp p = new ModalPopUp();
JFrame frame = new JFrame();
frame.setSize(400, 400);
frame.setVisible(true);
p.popIt(null, 100, 100);
System.out.println("Waiting upto 42s for popup click");
synchronized (modalMonitor) {
  modalMonitor.wait(42000);
}
p.stopIt();
System.out.println("Popup was clicked or 42s passed");
}
}