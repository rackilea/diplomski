public class ConcreteClass extends PreConcreteClass{
   private List<Object> internalDS;
   public ConcreteClass() {
      super();
      internalDS = new ArrayList<>();
      ...
   }
   @Override
   protected void update() {
      ....
      for(Object o : internalDS) {
         ...
      }
      ...
}