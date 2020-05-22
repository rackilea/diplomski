public static void main(String[] args) throws IOException {
    CommonSwiftClient swift = ContextBuilder.newBuilder("swift").endpoint("http://localhost:8080/auth/v1.0")
            .credentials("test:test", "test").buildApi(CommonSwiftClient.class);

    SwiftObject segment1 = swift.newSwiftObject();
    segment1.getInfo().setName("foo/bar/1");
    segment1.setPayload("foo");
    swift.putObject("container", segment1);

    SwiftObject segment2 = swift.newSwiftObject();
    segment2.getInfo().setName("foo/bar/2");
    segment2.setPayload("bar");
    swift.putObject("container", segment2);

    swift.putObjectManifest("container", "foo/bar2");

    SwiftObject dlo = swift.getObject("container", "foo/bar", GetOptions.NONE);
    InputStream input = dlo.getPayload().openStream();
    while (true) {
        int i = input.read();
        if (i < 0) {
            break;
        }
        System.out.print((char) i);
    }
}