@Test
public void getUrl_worksWithUrlLessThan16Length() {
    A test1 = new A(driver);
    String url = "www.google.com";
    A.setUrl(url);
    assertTrue(A.getUrl().equals(url));
}