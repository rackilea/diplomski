@BeforeSuite
public void testInternalAccess() {
    URL url = null;
    try {
        url = new URL("http://internalpage");
        InputStream is = url.openConnection().getInputStream();
    } catch (Exception e) {
        fail();
    }
}