String testCase="";

@Test
public void executeTestStep(String name) {
    if (A.get() == ADD) {
        performAdd(name);
        testCase = "Add Operation";
    } else  (A.get() == EDIT) {
        perform(name);
         testCase = "Edit Operation";
    }  
System.out.println("Test Case: " +testCase);        
}