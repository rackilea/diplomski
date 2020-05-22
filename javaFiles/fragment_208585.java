InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
ActionMap am = getActionMap();

im.put(KeyStroke.getKeyStroke(KeyEvent.VK_PERIOD, 0), "popup");
am.put("popup", new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
        popup.pack();
        Dimension popupSize = popup.getPreferredSize();
        int width = getWidth();
        int height = getHeight();

        int x = (width - popupSize.width) / 2;
        int y = (height - popupSize.height) / 2;

        popup.show(TestPane.this, x, y);
    }
});