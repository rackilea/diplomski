//Initialize PDF document
PdfDocument pdf = new PdfDocument(new PdfWriter(dest));
// Initialize document
Document document = new Document(pdf);
Paragraph p = new Paragraph()
    .add("Be prepared to read a story about a London lawyer "
       + "named Gabriel John Utterson who investigates strange "
       + "occurrences between his old friend, Dr. Henry Jekyll, "
       + "and the evil Edward Hyde.");
document.add(p);
document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));

//Set column parameters
...
//Define column areas
...
document.setRenderer(new ColumnDocumentRenderer(document, columns)); 
document.add(new AreaBreak(AreaBreakType.LAST_PAGE));   
// Add the full Jekyl and Hyde text
document.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
document.setRenderer(new DocumentRenderer(document)); 
document.add(new AreaBreak(AreaBreakType.LAST_PAGE));
p = new Paragraph()
    .add("This was the story about the London lawyer "
       + "named Gabriel John Utterson who investigates strange "
       + "occurrences between his old friend, Dr. Henry Jekyll, "
       + "and the evil Edward Hyde. THE END!");
document.add(p);
//Close document
document.close();