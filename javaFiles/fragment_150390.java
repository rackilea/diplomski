public void gotoNextScreen(ComponentEvent e) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            changeFrame(currentScreen.getNextScreen(), null);
        }
    });   
}