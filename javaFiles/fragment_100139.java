private class ClearAction extends AbstractAction {
    public ClearAction(String name) {
        super(name);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (JLabel[] labelRow : labelGrid) {
            for (JLabel cell : labelRow) {
                cell.setIcon(blankIcon);
            }
        }
    }
}