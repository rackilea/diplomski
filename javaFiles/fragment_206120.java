functionPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW)
    .put(KeyStroke.getKeyStroke("1"),"1 key");

functionPanel.getActionMap().put("1 key",new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent ev) {
        // perform operation here
    }
});