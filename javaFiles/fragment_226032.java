public class UAppWin {
    private JFrame frame;

    public UAppWin(String label, int nphases) {
        //System.out.println("UApp \"" + label + "\" (" + nphases + " phases)");
        JLabel label = new JLabel("UApp \"" + label + "\" (" + nphases + " phases)");


        frame = new JFrame("title");
        frame.add(label);
        frame.setVisible(true);
    }