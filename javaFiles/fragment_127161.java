private static URL getURL() {
    try {
        return new URL("https://localhost:8181/myApp/myService?wsdl");
    } catch (MalformedURLException ex) {
        Logger.getLogger(DataStoreWS_Service.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    }
}