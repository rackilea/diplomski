public static void main(String[] args) {
    ...
    SwingUtilities.invokeLater() {
        @Override()
        new Runnable() {
            new MainFrame().setVisible(true);
        }
    };        
}