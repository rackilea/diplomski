public class MyJob implements Job {

    public void testFunction() {
        MyClassWithStaticCounter.increaseCounter(1);
        System.out.println(MyClassWithStaticCounter.getCounter());
    }

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        testFunction();
    }
}