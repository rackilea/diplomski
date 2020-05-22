String pathTip = "Sets the tmp path.";
JPanel pathPanel = new JPanel() {
    private static final long serialVersionUID = 1L;
    public JToolTip createToolTip() {
        return new JMultiLineToolTip();
    }
};
pathPanel.setLayout(new BorderLayout());
pathPanel.setToolTipText(pathTip);