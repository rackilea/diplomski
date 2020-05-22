public ButtonFactory {

    /*
    * In such situation, where you select one from few states (like you do for colors)
    * it's also better to use enum instead of String. It's more convenient to reuse your code. 
    */
    public static Button getButton(ButtonType type) {
        if (type == ButtonType.GREEN)
            return GreenButton.INSTANCE;
        if (type == ButtonType.RED)
            return RedButton.INSTANCE;
    }

    public static enum ButtonType {
        GREEN, RED;
    }
}