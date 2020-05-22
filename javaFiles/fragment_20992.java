...
    @Override
    public void endDocument() throws SAXException {
        StringBuilder resultFile = new StringBuilder();
        resultFile.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        resultFile.append("<Movies>");
        for (String childNode : result) {
            resultFile.append(childNode.toString());
        }
        resultFile.append("</Movies>");

        System.out.println("=== Resulting XML containing Movies where " + tagToMatch + " is one of " + tagContents + " ===");
        System.out.println(resultFile.toString());
    }

}