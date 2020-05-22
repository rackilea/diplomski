class SedimentPanel extends JPanel {
    private TitledBorder titledBorder = BorderFactory.createTitledBorder(null, "border title", TitledBorder.CENTER,
            TitledBorder.DEFAULT_POSITION);

    public SedimentPanel() {
        super();
        setBorder(titledBorder);
        setPreferredSize(new Dimension(400, 300));
    }

    public void setTitle(String title) {
        titledBorder.setTitle(title);
        repaint();
    }

}