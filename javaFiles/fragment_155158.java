public class AddAirport {
    // Parent is a frame...
    public AddAirport(JFrame parent){
        initcomp(parent);
    }

    public void initcomp(JFrame parent){
        JPanel panel = new JPanel();
        JLabel label1 = new JLabel("hekllo");
        label1.add(panel);
        // Attempt to add the parent frame to the JPanel
        // Can't be done...
        panel.add(parent);
    }
}