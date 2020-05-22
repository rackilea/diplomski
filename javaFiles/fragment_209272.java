public GamePanel() {
    ...
    InputMap inputMap = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    inputMap.put(KeyStroke.getKeyStroke("SPACE"), "shootSpell");
    getActionMap().put("shootSpell", new AbstractAction() {
        @Override
        public void actionPerformed(ActionEvent e) {
            spells.add(new BlueSpell(...));
        }
    });
}