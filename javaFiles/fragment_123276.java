public static void main(String[] args){
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            JFrame _mf= new MainFrame();
            _mf.setVisible(true);
        }
    });
}