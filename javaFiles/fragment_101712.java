public static void wrong(final Component component) {

    component.setBackground(Color.RED);
    Timer   timer = new Timer(2, wrongAction);// <-- Here wrongAction is not the one you
                                              // define on the next line

    wrongAction = new ActionListener() { // <-- This is a new ActionListener but Timer
                                         // has no knowledge about it.
        @Override
        public void actionPerformed(ActionEvent e) {

            int green = component.getBackground().getGreen();
            int blue = component.getBackground().getBlue();
            component.setBackground(new Color(255, green + 1, blue + 1));
            if (component.getBackground() == Color.WHITE) {
                timer.stop();
            }
        }
    };

    timer.start();

}