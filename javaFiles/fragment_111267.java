public static synchronized Properties getConfig() {
    System.out.println("---");
    if (s_props == null) {
        List<URL> resources = CPScanner.scanResources(new ResourceFilter().archiveName("*"));
        for (URL resource : resources) {
            if (resource.getFile().matches(".*jmulticonfig\\..*\\.properties$")) {
                System.out.println("*** -> " + resource);
            }
        }

    }
    return s_props;
}