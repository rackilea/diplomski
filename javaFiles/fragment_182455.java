Document doc = DocumentBuilderFactory.newInstance()
                   .newDocumentBuilder().parse(new File("input.xml"));

XPath xp = XPathFactory.newInstance().newXPath();

try {
    String logo = xp.evaluate("/HomePageData/LogoTopLeft/text()", doc);
    String signIn = xp.evaluate("//SignInLink/text()", doc);
    String signUp = xp.evaluate("//SignUpLink/text()", doc);

    System.out.println( "logo = " + logo +
                        "; signIn = " + signIn +
                        "; signUp = " + signUp);
} catch (XPathExpressionException e) {
    e.printStackTrace();
}