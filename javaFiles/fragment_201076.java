CloudFilesClient client = ContextBuilder.newBuilder("cloudfiles-us")
    .credentials(USERNAME, APIKEY)
    .buildApi(CloudFilesClient.class);

client.createContainer("sample");

SwiftObject object = client.newSwiftObject();
object.getInfo().setName("somefile.txt");
object.setPayload("file or bytearray or something else here");
client.putObject("sample", object);

// ...

client.close();