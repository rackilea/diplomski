public static void main(String[] args) {
    try {
        UserAgent userAgent = new UserAgent();
        userAgent.visit("http://feeds.foxnews.com/foxnews/latest");

        Elements items = userAgent.doc.findEach("<item>");
        Elements titles = items.findEach("<title>");

        for (Element title : titles) {
            String titleText = title.getComment(0).getText();
            System.out.println(titleText);
        }
    } catch (JauntException e) {
        System.err.println(e);
    }
}