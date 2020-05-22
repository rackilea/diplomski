public class CamelTimerSqlQueryExample {
    public static final void main(String[] args) throws Exception {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("timerSelectQueryApplicationContext.xml");
        CamelContext camelContext = new SpringCamelContext(appContext) ;
        try {
            camelContext.start();
            Thread.sleep(5000);
        } finally {
            camelContext.stop();
        }
    }
}