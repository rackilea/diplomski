// Start with a new document
XWPFDocument doc = new XWPFDocument();

// Add a 3 column, 3 row table
XWPFTable table = doc.createTable(3, 3);

// Set some text in the middle
table.getRow(1).getCell(1).setText("EXAMPLE OF TABLE");

// table cells have a list of paragraphs; there is an initial
// paragraph created when the cell is created. If you create a
// paragraph in the document to put in the cell, it will also
// appear in the document following the table, which is probably
// not the desired result.
XWPFParagraph p1 = table.getRow(0).getCell(0).getParagraphs().get(0);

XWPFRun r1 = p1.createRun();
r1.setBold(true);
r1.setText("The quick brown fox");
r1.setItalic(true);
r1.setFontFamily("Courier");
r1.setUnderline(UnderlinePatterns.DOT_DOT_DASH);
r1.setTextPosition(100);

// And at the end
table.getRow(2).getCell(2).setText("only text");

// Save it out, to view in word
FileOutputStream out = new FileOutputStream("simpleTable.docx");
doc.write(out);
out.close();