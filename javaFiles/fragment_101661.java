public static void main(String[] args) throws Exception {

    Document content = Jsoup.parse(
      "<div class=\"submitted\">" +
      "  <strong><a title=\"View user profile.\" href=\"/user/1\">user1</a></strong>" +
      "  on 27/09/2011 - 15:17 " + 
      "  <span class=\"via\"><a href=\"/goto/002\">www.google.com</a></span>" +
      "</div> ");

    // create a clone of the element so we do not destroy the original
    Element submitted = content.getElementsByClass("submitted").first().clone();

    // remove the elements that you do not need 
    submitted.getElementsByTag("strong").remove();
    submitted.getElementsByClass("via").remove();

    // print the result (demo)
    System.out.println(submitted.text());
}