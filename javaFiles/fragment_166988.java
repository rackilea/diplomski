@RequestMapping("/trackings/add")
public void addTracking() {
    final String uri = "https://api.aftership.com/v4/trackings";
    MainTracking mainTracking = new MainTracking();
    Tracking tracking = new Tracking();
    tracking.setTracking_number("7835112328"); // Be careful with     this number has generated different every time.!!
    mainTracking.setTracking(tracking);

    RestTemplate restTemplate = new RestTemplate();
    HttpEntity<MainTracking> entity = new HttpEntity<MainTracking>(mainTracking, HttpHeaderConfig());

    ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);
    System.out.println(response.getBody());
 }