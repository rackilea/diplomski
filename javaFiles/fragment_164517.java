public XYZOuputStream(String productid, String password, String path, String    productname, boolean overwrite, boolean iscompressed) throws Exception {
    this.productid = productid;
    this.path = path;
    this.productname = (productname == null) ? DEFAULT_PRODUCT_NAME :    productname;
    this.password = password;
    this.overwrite = overwrite;
    this.iscompressed = iscompressed;
    // if(someCondition) for example path != null call initOutputStream();
    // initOuputStream();