@Autowired
private WebServiceTemplate webServiceTemplate;

public void run() {
   ObjectFactory objectFactory = new ObjectFactory();

   // Create the request payload
   OhMyGawd ohMyGawd = objectFactory.createOhMyGawd();
   ohMyGawd.setValue(...);

   OhMyGawdResponse response = (OhMyGawdResponse) webServiceTemplate.marshalSendAndReceive(
        ohMyGawd, 
        new SoapActionCallback("http://oh.my.gawd")
);

...