public static void main(String[] args) {
    Runnable guiCreator = new Runnable() {
        public void run() {
            JFrame fenster = new JFrame("Hallo Welt mit Swing");
            fenster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            fenster.setVisible(true);
        }
    };
    SwingUtilities.invokeLater(guiCreator);
}