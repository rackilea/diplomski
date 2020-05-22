public class Editor {

  public Editor() {

    // Create JFrame For Editor
    JFrame SimplyHTMLJFrame = new JFrame();

    SimplyHTMLJFrame.setTitle("Simply HTML - Editor");
    SimplyHTMLJFrame.setSize(800, 600);
    SimplyHTMLJFrame.setResizable(true);
    SimplyHTMLJFrame.setLocationRelativeTo(null);
    SimplyHTMLJFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    SimplyHTMLJFrame.addWindowListener(new WindowAdapter() {
      // Program Closing Alert
      public void windowClosing(WindowEvent e) {
        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to quit?\n" + "All unsaved changes will be lost!", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

        if (result == JOptionPane.YES_OPTION) {

          System.exit(0);

        } else {

          // Do nothing

        }
      }
    }); // The error is here it underlines windowClosing in red

    SimplyHTMLJFrame.setVisible(true);
    System.out.println("Editor - JFrame 'SimplyHTMLJFrame' - Created");

  }