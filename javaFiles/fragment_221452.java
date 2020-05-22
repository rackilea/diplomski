public void refreshLikesSharesClicksAndTotal() throws JDOMException, IOException {
        URL fqlURL = new URL("https://api.facebook.com/method/fql.query?query=select%20like_count,%20total_count,%20share_count,%20click_count%20from%20link_stat%20where%20url=%22http://heise.de%22");
        URLConnection openConnection = fqlURL.openConnection();     
        String contentType = openConnection.getContentType();
        Document inputXML = new SAXBuilder().build(fqlURL);
        DocType docType = new DocType("xml", "http://www.w3.org/2001/XMLSchema-instance");
        inputXML.setDocType(docType);
        Element root = inputXML.getRootElement();

        Element fqlResponse = root.getChild("link_stat", root.getNamespace());
        Element likes = fqlResponse.getChild("like_count", root.getNamespace());
        Element shares = fqlResponse.getChild("share_count", root.getNamespace());
        Element clicks = fqlResponse.getChild("click_count", root.getNamespace());
        Element total = fqlResponse.getChild("total_count", root.getNamespace());

        int alikes = Integer.parseInt(likes.getText());
        int ashares = Integer.parseInt(shares.getText());
        int aclicks = Integer.parseInt(clicks.getText());
        int atotal = Integer.parseInt(total.getText());

    }