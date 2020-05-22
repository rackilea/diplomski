PDDocument doc = new PDDocument();
PDPage page = new PDPage();
doc.addPage( page );

PDPageContentStream contentStream = new PDPageContentStream(doc, page);

String[][] content = {{"a","b", "1"}, 
                      {"c","d", "2"}, 
                      {"e","f", "3"}, 
                      {"g","h", "4"}, 
                      {"i","j", "5"}} ;

drawTable(page, contentStream, 700, 100, content);
contentStream.close();
doc.save("test.pdf" );