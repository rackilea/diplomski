public class HttpClientDemo {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("/si-email-context.xml");
        RequestGateway requestGateway = context.getBean("requestGateway", RequestGateway.class);

        Pojo pojo = new Pojo("Fred", "Bloggs");

        Map<String, String> requestMap = new HashMap<String, String>();
        requestMap.put("fName", pojo.getFName());
        requestMap.put("sName", pojo.getSName());

        String reply = requestGateway.echo(requestMap);
        System.out.println("Replied with: " + reply);
    }
}