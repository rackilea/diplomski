private static final String EXIT = "Exit";
private Action exit = new AbstractAction(EXIT) {

        @Override
        public void actionPerformed(ActionEvent e) {
            f.dispatchEvent(new WindowEvent(
                f, WindowEvent.WINDOW_CLOSING));
        }
    };
private JButton b = new JButton(exit);