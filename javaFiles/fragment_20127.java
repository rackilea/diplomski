private JButton makeJButton(String label, String toolTip, Color bgColor, final Color highlight) {
    JButton button = new JButton(label);
    button.setToolTipText(toolTip);
    button.setBackground(bgColor);
    button.setHorizontalAlignment(JButton.CENTER);
    button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Highlighter.shadeSymmetric(currentCell, highlight);
        }
    });
    return button;
}