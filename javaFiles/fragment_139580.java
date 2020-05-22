public class TopPanel extends JPanel {

    public TopPanel() {     
        // get rid of the recursion
        // TopPanel tp = new TopPanel();

        // add the label to the current TopPanel object, the "this"
        add(new JLabel("Course Info"));

        // setSize(300,300); // generally not a good idea

        // tp.setVisible(true); // not needed
    }

    // this is an overly simplified method. You may wish to calculate what the 
    // preferred size should be, or simply don't set it and let the components
    // size themselves.
    public Dimension getPreferredSize() {
       return new Dimension(300, 300); 
    }

}