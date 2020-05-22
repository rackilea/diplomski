public class MyFrame extends javax.swing.JFrame {

   private Timer timer = null;
   ImageIcon[] icons = new ImageIcon[3];
   int index = -1;

   public MyFrame() {
       initComponents();
       icons[0] = new ImageIcon(...);
       icons[1] = new ImageIcon(...);
       icons[2] = new ImageIcon(...);

       timer = new Timer(2000, new ActionListener(){
           public void actionPerformed(ActionEvent e) {
               if (index + 1 > 2) {
                   index = 0;
                   jLabel3.setIcon(icons[index]);
               } else {
                   index++;
                   jLabel3.setIcon(icons[index]);
               }
           }
       });
   }
}