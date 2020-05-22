public void example() throws Exception{

        XWPFDocument document = new XWPFDocument(); 
        //Append a link to 
        appendExternalHyperlink("https://poi.apache.org", " Link to POI", document.createParagraph());

        document.write(new FileOutputStream("resultat.docx"));
    }

    /**
     * Appends an external hyperlink to the paragraph.
     * 
     * @param url The URL to the external target
     * @param text The linked text
     * @param paragraph the paragraph the link will be appended to.
     */
    public static void appendExternalHyperlink(String url, String text, XWPFParagraph paragraph){

        //Add the link as External relationship
        String id=paragraph.getDocument().getPackagePart().addExternalRelationship(url, XWPFRelation.HYPERLINK.getRelation()).getId();

        //Append the link and bind it to the relationship
        CTHyperlink cLink=paragraph.getCTP().addNewHyperlink();
        cLink.setId(id);

        //Create the linked text
        CTText ctText=CTText.Factory.newInstance();
        ctText.setStringValue(text);
        CTR ctr=CTR.Factory.newInstance();
        ctr.setTArray(new CTText[]{ctText});

        //Insert the linked text into the link
        cLink.setRArray(new CTR[]{ctr});
    }