class CustomArrowUI extends BasicComboBoxUI {
    @Override
    protected JButton createArrowButton() {
        return new JButton(new ImageIcon("resources/icon.png"));
        // If you do not want to use an image icon:
        // return new BasicArrowButton(BasicArrowButton.NORTH, Color.darkGray, Color.yellow, Color.PINK, Color.lightGray);
    }
}