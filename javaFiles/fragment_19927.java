public static Long time(final Callable<?> r) throws Exception {
    final long start = System.currentTimeMillis();
    r.call();
    return Long.valueOf(System.currentTimeMillis() - start);
}

public static void main(final String[] args) throws Exception {
    final URL url = new URL("http://test-api.rescuegroups.org/v5/public/swagger.php");
    System.out.println(String.format(   "%dms to get 'info.contact.email' with JSONPath",
                                        time(() -> new JSONPath("info.contact.email").getWithin(url.openStream()))));
    System.out.println(String.format(   "%dms to just download the entire document otherwise",
                                        time(() -> new Scanner(url.openStream()).useDelimiter("\\A").next())));
    System.out.println(String.format(   "%dms to bluntly map it entirely with Jackson and access a specific field",
                                        time(() -> new ObjectMapper()
                                                .readValue(url.openStream(), ObjectNode.class)
                                                .get("info").get("contact").get("email"))));
}