static {
    try {
        System.load("/path_to_sso/my.so");
    } catch (UnsatisfiedLinkError unsatisfiedlink) {
        //handle it
    }
}