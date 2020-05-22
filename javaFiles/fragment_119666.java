public static Loader instance() {
    if (instance == null) {
        instance = new Loader();
        System.out.println("Loader ready");
    }
    return instance;
}