@Test
public void getFullUrl() {
String testurl = "facebook.com";
String testurl2 = "http://facebook.com";
assertEquals(bookmarkEngine.getFullUrl(testurl),"http://facebook.com");
assertEquals(bookmarkEngine.getFullUrl(testurl2),"http://facebook.com");
}