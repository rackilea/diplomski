public static void main(String[] args){
    Thread t = new Thread(new Runnable() {

        @Override
        public void run() {
            Goo myGoo = new Goo();      

        }
    });
    t.start(); 
}