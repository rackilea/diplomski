WebClient webClient = new WebClient();
// You might need this configuration if HtmlUnit fails without it
webClient.getOptions().setThrowExceptionOnScriptError(false);
webClient.waitForBackgroundJavaScript(10 * 1000);
HtmlPage page = webClient.getPage(url);
String xml = page.asXml();

ConverterProperties properties = new ConverterProperties().setBaseUri(url);
HtmlConverter.convertToPdf(source, new PdfWriter("result.pdf"), properties);