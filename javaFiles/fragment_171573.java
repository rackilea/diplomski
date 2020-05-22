public class RunMyTests{

   public void main(String... args) {
       JUnitCore core= new JUnitCore();
       core.addListener(new MyTestListener());
       core.run(MyTestSuite.class);
    }
 }