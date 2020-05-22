public class NewClass extends JFrame {

    public NewClass() throws HeadlessException {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);
        menu.add(new JMenuItem("Open..."));
        menu.add(new JMenuItem("Save"));
        menu.add(new JMenuItem("Save as..."));
        menu.addSeparator();
        menu.add(new JMenuItem("Delete"));

        setJMenuBar(menuBar);
        setSize(new Dimension(500,500));
        setVisible(true);
    }

    public static void main(String[] args) {
        try {
           //UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
           //UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
           UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());      
           new NewClass();
        } catch (ClassNotFoundException ex) {
          Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
          Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
          Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
          Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}