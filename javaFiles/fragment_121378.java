JComboBox<String> box = new JComboBox<>();
box.setEditable(true);
box.setUI(new BasicComboBoxUI() { // make the down arrow invisible
    protected JButton createArrowButton() {
        return new JButton() {
            public int getWidth() {
                return 0;
            }

            @Override
            public synchronized void addMouseListener(MouseListener l) {
            }
        };
    }
});