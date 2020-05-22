public class MyTestRule implements TestRule {

        //Configure CONDITION value from application properties
    private static String condition = "COND1"; //or set it to COND2

   @Override
   public Statement apply(Statement stmt, Description desc) {

           return new Statement() {

         @Override
         public void evaluate() throws Throwable {

                 MyTestCondition ann = desc.getAnnotation(MyTestCondition.class);

                 //Check the CONDITION is met before running the test method
                 if(ann != null &&  ann.condition().name().equals(condition)) {
                         stmt.evaluate();
                 }
         }         
       };
    }
}