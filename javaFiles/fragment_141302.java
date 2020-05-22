public class JPanelList extends JPanel {
    private static final long serialVersionUID = 1L;
    private JPanel mainList;
    private List<JPanel> panels = new ArrayList<JPanel>();
    public JPanelList() { this(new ArrayList<JPanel>()); }
    public JPanelList(List<JPanel> panels) {
        setLayout(new BorderLayout());
        mainList = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.weighty = 1;
        mainList.add(new JPanel(), gbc);
        add(new JScrollPane(mainList));
        addPanels(panels);
    }
    public void addPanels(List<JPanel> panels) {
        for (JPanel panel : panels)
            addPanel(panel);
    }
    public void addPanel(JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.weightx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        mainList.add(panel, gbc, 0);
        panels.add(panel);
        validate();
        repaint();
    }
}