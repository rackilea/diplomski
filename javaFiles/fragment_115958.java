public abstract class AbstractTestParent implements ITest {

    private String testName = "";

    // This method actually is what provides you with the functionality of renaming 
    // your tests for the standard testNG logger
    @Override 
    public String getTestName(){
        return this.testName;
    }

    protected abstract CommonTestParameter getTestParameter();    

    @BeforeMethod
    public void beforeMethod(Method aMethod) {
        this.testName = aMethod.getName() + "[" + getTestParameter().toString() + "]";
    }
}