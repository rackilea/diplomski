public class MyCrawler {
   // Compile once, run multiple times
   private static final Matcher COMMENT_REMOVER = Pattern.compile("the regex here...").matcher("");

   public void doCrawl() {
      String htmlString = loadHtmlSource();

      htmlString = COMMENT_REMOVER.reset(htmlString).replaceAll("");
   }

   ...
}