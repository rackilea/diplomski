XWPFHeaderFooterPolicy policy = sampleDoc.getHeaderFooterPolicy();
if (policy.getDefaultHeader() == null && policy.getFirstPageHeader() == null
       && policy.getDefaultFooter() == null) {
   // Need to create some new headers
   // The easy way, gives a single empty paragraph
   XWPFHeader headerD = policy.createHeader(policy.DEFAULT);
   headerD.getParagraphs(0).createRun().setText("Hello Header World!");

   // Or the full control way
    CTP ctP1 = CTP.Factory.newInstance();
    CTR ctR1 = ctP1.addNewR();
    CTText t = ctR1.addNewT();
    t.setStringValue("Paragraph in header");

    XWPFParagraph p1 = new XWPFParagraph(ctP1, sampleDoc);
    XWPFParagraph[] pars = new XWPFParagraph[1];
    pars[0] = p1;

    policy.createHeader(policy.FIRST, pars);
} else {
   // Already has a header, change it
}