ContainerListener containerL = new ContainerListener() {

    @Override
    public void componentRemoved(ContainerEvent e) {
        LOG.info("" + e);
    }

    @Override
    public void componentAdded(ContainerEvent e) {
        LOG.info("" + e);
    }
};
table.addContainerListener(containerL);
FocusListener focusL = new FocusListener() {

    @Override
    public void focusGained(FocusEvent e) {
        LOG.info("" + e);
       // following line is a hack around: force the popup open
       // ((JComboBox) cellEditor.getComponent()).setPopupVisible(true);
    }

    @Override
    public void focusLost(FocusEvent e) {
        LOG.info("" + e);
    }

};
cellEditor.getComponent().addFocusListener(focusL);