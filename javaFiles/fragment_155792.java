public void createPdf(String dest) throws IOException {
    PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
    Document document = new Document(pdf);
    List topLevel = new List();
    ListItem item1 = new ListItem();
    item1.add(new Paragraph().add("Item 1"));
        List secondLevel = new List();
        secondLevel.add("Sub Item 1");
        ListItem subItem2 = new ListItem();
        subItem2.add(new Paragraph("Sub Item 2"));
            List thirdLevel = new List();
            thirdLevel.add("Sub Sub Item 1");
            thirdLevel.add("Sub Sub Item 2");
        subItem2.add(thirdLevel);
        secondLevel.add(subItem2);
    item1.add(secondLevel);
    topLevel.add(item1);
    document.add(topLevel);
    document.close();
}