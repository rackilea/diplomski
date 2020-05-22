public static void main(String[] args) throws Exception {
    ClientCache cache = new ClientCacheFactory().set("cache-xml-file", "client-cache.xml").set("log-level", "config").create();
    Region region = cache.getRegion("TEST");
    region.put("key1", new MyPojo("attribute1", "attribute2"));
    cache.close();
    System.exit(0);
}