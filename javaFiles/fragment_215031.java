LogFactory.getFactory().setAttribute("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.NoOpLog");

java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); 
java.util.logging.Logger.getLogger("org.apache.commons.httpclient").setLevel(Level.OFF);

WebClient client = new WebClient(BrowserVersion.CHROME);
client.getOptions().setJavaScriptEnabled(true);
client.getOptions().setThrowExceptionOnScriptError(false);
client.getOptions().setThrowExceptionOnFailingStatusCode(false);

String url = "http://lsa.colorado.edu/cgi-bin/LSA-pairwise.html";
final HtmlPage page = client.getPage(url);

HtmlForm htmlForm = page.getForms().get(0);
HtmlTextArea txtA = htmlForm.getTextAreaByName("txt1");
txtA.setText("hello");
HtmlSubmitInput submitBt = htmlForm.getInputByValue("Submit Texts");

// change the form action attribute to the correct one  
htmlForm.setAttribute("action", "http://lsa.colorado.edu/cgi-bin/LSA-pairwise-x.html");

HtmlPage page2 = submitBt.click();
System.out.println(page2.asText());