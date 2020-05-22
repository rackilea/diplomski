public enum Toy {
     DOLL() {
          @Override public void execute() { 
               System.out.println("I'm a doll."); 
          }
     },
     SOLDIER() {
          @Override public void execute() { 
               System.out.println("I'm a soldier."); 
          }
     };
     //template method
     public abstract void execute();
}