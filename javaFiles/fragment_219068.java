public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable(){
        public void run() {
            FarbBalkenTest fbt = new FarbBalkenTest();
            fbt.init();
        }
    });
}