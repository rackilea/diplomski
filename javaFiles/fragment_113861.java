DataFlavor dfHTML = new DataFlavor("text/html; charset=Unicode");
boolean hasTransferableHTMLText = (contents != null) && contents.isDataFlavorSupported(dfHTML);
if (hasTransferableHTMLText)
{
    InputStream is = (InputStream)contents.getTransferData(dfHTML);
    String htmldata = org.apache.commons.io.IOUtils.toString(is, "Unicode");  

    Document doc = Jsoup.parse(htmldata);
    System.out.println(doc.html());
    //...
}