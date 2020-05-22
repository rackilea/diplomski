public class CenteringPanel extends JPanel {
    public CenteringPanel(JComponent child) {
        GridBagLayout gbl = new GridBagLayout();
        setLayout(gbl);
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = GridBagConstraints.REMAINDER;
        gbl.setConstraints(child, c);
        add(child);
    }
}