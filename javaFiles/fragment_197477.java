@DataProvider(name = "400_links")
public static String[][] getLinks() {
   // find your own way to create links here
   return new String[][] {{"http://foo"}, {"http://bar"}, ... , {"http://xyz"}};
}

@Test(dataProvider = "400_links")
public void checkAllLinks(String link) {
   checkValidityOrWhatever(link);
}

public void checkValidityOrWhatever(String link) {
   //blah blah http ftw
}