public class MyJob implements Job {    
    public void testFunction() {
        System.out.println("Running Test!");
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        testFunction();
    }
}