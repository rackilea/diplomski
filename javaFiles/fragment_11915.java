public class RunProgram extends JFrame implements ActionListener {

   public RunProgram () {
      // to do logic to initialise
      initComponents();
   }
   public void initComponents() {
       JButton addbook = new JButton("Add Book");
       addbook.setActionCommand("Add Book");
       addbook.addActionListener(this);

      // add code to initialise button and add them to correct tabbed pane
   }
 }