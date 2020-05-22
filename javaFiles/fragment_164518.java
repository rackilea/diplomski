private XYZOuputStream(String productid, String path, String productname,   String password) throws Exception {
    this(productid, password, path, productname, false, false)
    initClient();
}

private XYZOuputStream(String productid, String productname) throws Exception {
    this(productid, DEFAULT_PASSWORD, DEFAULT_PATH, productname, false, false)
}