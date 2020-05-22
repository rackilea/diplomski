class Test {

     private static Scanner scanner;
     private static Thread inputThread = new Thread() {
         public void run() {
             scanner = new Scanner(System.in);

             while(true) {
                  //scanner.nextLine();
             }
         }
     }; 

     public static void main(String[] args) {
          inputThread.start();

          //handle everything else on main thread
     }
}