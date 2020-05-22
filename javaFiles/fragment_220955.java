public class ClassToTest implements Runnable {

   private final ClassToMock aClass;
   private final Logger logger;

   //injection of collaborators through the constructor
   public ClassToTest(ClassToMock aClass, Logger logger) {
       this.aClass = aClass;
       this.logger = logger;
   }

   @Override
   public void run() {
       try{
           aClass.doSomething("some parameter");
       } catch(IllegalStateException e) {
           logger.error("Something bad happened", e);
           recover();
       }
   }

   public void recover() { //there is no need for this method to be public - see Effective Java item 13
      logger.info("I am recovering");
   }
}