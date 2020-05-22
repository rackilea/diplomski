public class your TestRunner extends BlockJUnit4ClassRunner{

  protected List<FrameworkMethod> computeTestMethods() {
        //this is all the @Test annotated methods
        List<FrameworkMethod> testAnnotatedMethods = super.computeTestMethods();
        //these are all the methods with your @TestPattern annotation
        List<FrameworkMethod> yourAnnotatedMethods = getTestClass().getAnnotatedMethods(TestPattern.class);

        //do whatever you need to do to generate the test 
        //methods with the correct parameters based on 
        //the annotation ?  
        //Might need to make fake or 
        //synthetic FrameworkMethod instances?

       ...

       //combine everyting into a single List
       List<FrameworkMethod> allTestMethods =...
       //finally return all the FrameworkMethods as a single list
       return allTestMethods;
 }

}