class SelectionListener extends AbstractAction { 

    private final double amount;
    public SelectionListener(double amount) {
        this.amount = amount;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        JCheckBox checkBox = (JCheckBox)event.getSource();
        if (checkBox.isSelected()) {
            total1 += amount;
        }
    }
}