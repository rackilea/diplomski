final String server = "chiexist1.worldbook.com";
final String port = "8080";
docBuilder = docFactory.newDocumentBuilder();
doc = null;
try {
    doc = docBuilder.parse("http://" + server + ":" + port + "/exist/webdav/db/portfolio/config/products.xml");
} catch{
    try{ 
        doc = docBuilder.parse("http://" + "localhost" + ":" + port + "/exist/webdav/db/portfolio/config/products.xml");
    } catch {
        // now we have an error we can't recover from
    }
}
...  // I meant to do this before.