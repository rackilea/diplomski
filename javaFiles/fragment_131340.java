public class MyCallable implements Callable<String>{

    private RestTemplate restTemplate;
    private Customer c;

    public MyCallable(RestTemplate rt, Customer cust) {
        this.restTemplate = rt;
        this.c = cust;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Customer no"+ c.getId() +"On thread Number"+Thread.currentThread().getId());
        return restTemplate.postForObject("http://localhost:3000/save", c, String.class);

    }
}