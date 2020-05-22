Logger logger = LogManager.getLogger("my.logger");

logger.info(new StructuredDataMessage("1", "hello!", "typeX").with("key1", "sd1"));
logger.info(new StringMapMessage().with("key1", "map1"));

List<String> lines = readLines();
assertTrue(lines.contains("my.logger/org.ops4j.pax.logging.it.Log4J2MessagesIntegrationTest typeX/sd1 [INFO] typeX [1 key1=\"sd1\"] hello!"));
assertTrue(lines.contains("my.logger/org.ops4j.pax.logging.it.Log4J2MessagesIntegrationTest ${sd:type}/map1 [INFO] key1=\"map1\""));