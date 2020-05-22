static void addPageNumbers(XWPFDocument doc, long startingNum) {
  CTBody body = document.getDocument().getBody();
  CTSectPr sectPr = body.isSetSectPr() ? body.getSectPr() : body.addNewSectPr();
  CTPageNumber pgNum = sectPr.isSetPgNumType() ? sectPr.getPgNumType() : sectPr.addNewPgNumType();
  pgNum.setStart(BigInteger.valueOf(startingNum));

  CTP ctp = CTP.Factory.newInstance();
  ctp.addNewR().addNewPgNum(); // Not sure why this is necessary, but it is.

  XWPFParagraph footerParagraph = new XWPFParagraph(ctp, document);
  footerParagraph.setAlignment(ParagraphAlignment.CENTER); // position of number
  XWPFParagraph[] paragraphs = { footerParagraph };

  XWPFHeaderFooterPolicy headerFooterPolicy = new XWPFHeaderFooterPolicy(document, sectPr);
  headerFooterPolicy.createFooter(STHdrFtr.FIRST, paragraphs);
  headerFooterPolicy.createFooter(STHdrFtr.DEFAULT, paragraphs); // DEFAULT doesn't include the first page
}