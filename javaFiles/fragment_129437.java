public class MySkeletonTest {
   private static void createAndShowGui() {
      MySkeleton mainPanel = new MySkeleton();

      int input = JOptionPane.showConfirmDialog(null, mainPanel, "Login",
            JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
      if (input == JOptionPane.OK_OPTION) {
         System.out.println("User Name: " + mainPanel.getUserName());

         // **** for testing purposes only. Never do this in a real app.
         System.out.println("Password:  " + new String(mainPanel.getPassword()));
      }
   }

   public static void main(String[] args) {
      SwingUtilities.invokeLater(new Runnable() {
         public void run() {
            createAndShowGui();
         }
      });
   }
}