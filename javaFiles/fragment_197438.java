final WebClient webClient = new WebClient();
HtmlPage page = webClient.getPage("http://<<YOUR URL HERE>>");

final HtmlDivision div = page.getFirstByXPath("//div[@class='dpxButton']");
page = div.click(); 
// This returns the page shown after the click