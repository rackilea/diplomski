@ComponentScan
@EnableAutoConfiguration
public class Application {
    public static void main(String[] args) {
        RestTemplate rt = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        String url = "https://jsonplaceholder.typicode.com/posts/1";
        ResponseEntity<String> res = rt.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(res);
    }
}