class InitialState extends TaskState {
    public void run() {
        System.out.println( "starting...");
    }
    public TaskState next() {
         return new FinalState();
    }
 }
 class FinalState extends TaskState  {
     public void run() {
         System.out.println("Finishing...");
     }
     public TaskState next(){
         return new InitialState();
    }
 }