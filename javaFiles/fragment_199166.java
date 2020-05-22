private TestClass() {
    panel = new JPanel(new MigLayout(new LC().fill().gridGap("0", "0").insetsAll("0").hideMode(3)));

    displayLabel = new JLabel("some text goes here");
    displayLabel.setFont(new Font("Dialog", Font.BOLD, 9));
    displayLabel.setMinimumSize(new Dimension(30, 10));
    panel.add(displayLabel, new CC().grow().push());

    panel.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            scale(displayLabel);
        }
    });
}