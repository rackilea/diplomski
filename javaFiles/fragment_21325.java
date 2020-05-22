public class DemoScheduleCron
{
    @Scheduled(cron="*/10 * * * * ?")
    //@Scheduled(fixedDelay = 10000)
    //@Scheduled(fixedRate = 10000)
    public void method1()
    {
        System.out.println("This method executs for every 10 seconds");
    }
}