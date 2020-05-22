try {
  final WebClient webClient = new WebClient();
  final HtmlPage page = webClient.getPage("http://htmlunit.sourceforge.net");
  assertEquals("HtmlUnit - Welcome to HtmlUnit", page.getTitleText());
}
catch (Exception e) {
  e.printStackTrace();
}