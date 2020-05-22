public static void main(String[] args){
    SwingUtilities.invokeLater(new Runnable(){
        @Override
        public void run() {
            new World("Hej", "/resources/stackoverflow5.png", 1024, 768);
        }
    });
}