public static void main(String[] args) {
    SwingUtilitiies.invokeLater(new Runnable(){
        public void run(){
            new Test();
        }
    });
}