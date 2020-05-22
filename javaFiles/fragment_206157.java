public class ExecutionListener extends RunListener
{
... //feel free to override other methods too

/**
 *  Called when an atomic test has finished, whether the test succeeds or fails.
 * */
public void testFinished(Description description) throws java.lang.Exception
{
    System.out.println("Finished execution of test case : "+ description.getMethodName());
}

/**
 *  Called when an atomic test fails.
 * */
public void testFailure(Failure failure) throws java.lang.Exception
{
    System.out.println("Execution of test case failed : "+ failure.getMessage());
}

/**
 *  Called when a test will not be run, generally because a test method is annotated with Ignore.
 * */
public void testIgnored(Description description) throws java.lang.Exception
{
    System.out.println("Execution of test case ignored : "+ description.getMethodName());
}