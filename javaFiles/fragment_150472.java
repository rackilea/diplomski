for (String confFile : Arrays.asList("/log4j2-test.xml", "/log4j2.yaml", "/log4j2.yml", "/log4j2.json", "/log4j2.jsn", "/log4j2.xml")) {
    URL resource = YourTestClass.class.getResource(confFile);
    if (resource != null) {
        System.out.format("found %s in: %s\n", confFile, resource.getFile());
    }
}