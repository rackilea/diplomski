StyledDocument style = pane.getStyledDocument();
Runnable runnable = new Runnable() {
        @Override
        public void run() {
            style.setCharacterAttributes(start, length, set, true);
        }
    };
    SwingUtilities.invokeLater(runnable);