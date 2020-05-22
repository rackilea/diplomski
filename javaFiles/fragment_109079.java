private void createKeybindings(JTable table) {
table.getInputMap(JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "Enter");
    table.getActionMap().put("Enter", new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent ae) {
            //do something on JTable enter pressed
        }
    });
}