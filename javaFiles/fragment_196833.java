private Path discoverRootDirectory() {
    String myAppHome = System.getenv("MYAPP_HOME");

    if (myAppHome == null) {
        return Paths.get(System.getProperty("user.home"), ".myapp");
    } else {
        return Paths.get(myAppHome);
    }
}