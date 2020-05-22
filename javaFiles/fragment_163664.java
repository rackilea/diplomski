private void uploadToRackspaceRegion() {
  Iterable<Module> modules = ImmutableSet.<Module> of(new Log4JLoggingModule());
  String provider = "swift-keystone"; //Region selection is limited to swift-keystone provider
  String identity = "username";
  String credential = "password";
  String endpoint = "https://identity.api.rackspacecloud.com/v2.0/";
  String region = "ORD";

  Properties overrides = new Properties();
  overrides.setProperty(LocationConstants.PROPERTY_REGION, region);
  overrides.setProperty(Constants.PROPERTY_API_VERSION, "2");

  BlobStoreContext context = ContextBuilder.newBuilder(provider)
        .endpoint(endpoint)
        .credentials(identity, credential)
        .modules(modules)
        .overrides(overrides)
        .buildView(BlobStoreContext.class);
  RestContext<CommonSwiftClient, CommonSwiftAsyncClient> swift = context.unwrap();
  CommonSwiftClient client = swift.getApi();

  SwiftObject uploadObject = client.newSwiftObject();
  uploadObject.getInfo().setName("test.txt");
  uploadObject.setPayload("This is my payload."); //input stream.

  String eTag = client.putObject("jclouds", uploadObject);
  System.out.println("eTag = " + eTag);

  SwiftObject downloadObject = client.getObject("jclouds", "test.txt");
  System.out.println("downloadObject = " + downloadObject.getPayload());

  context.close();
}