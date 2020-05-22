PDDocument document = new PDDocument();
PDPage page = new PDPage(PDPage.PAGE_SIZE_LETTER);
document.addPage(page);
PDPageContentStream content = new PDPageContentStream(document,page);

//generate data for first page

content.close();

//if number of results exceeds what can fit on the first page
page = new PDPage(PDPage.PAGE_SIZE_LETTER);
document.addPage(page);
content = new PDPageContentStream(document,page);

//generate data for second page

content.close();