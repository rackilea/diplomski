private static class MyButton extends JButton {

    private static final Font font = new Font("Dialog", Font.BOLD, 24);

    public MyButton(String text) {
        super(text);
        this.setFont(font);
    }
}