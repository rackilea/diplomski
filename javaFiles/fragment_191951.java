String baseUri = "path/to/doc/";

LoadOptions loadOptions = new LoadOptions();
loadOptions.setEncoding(Charset.forName("UTF-8"));
com.aspose.words.Document doc = new com.aspose.words.Document(baseUri +"test.html", loadOptions);

for (Section sectoin : doc.getSections())
{
       PageSetup ps = sectoin.getPageSetup();
       ps.setPaperSize(PaperSize.A4);
       ps.setTopMargin(0.0);
       ps.setBottomMargin(1.0);
       ps.setLeftMargin(1.0);
       ps.setRightMargin(1.0);

}

OutputStream outputStream = new FileOutputStream(baseUri +"Test.pdf");
doc.save(outputStream, com.aspose.words.SaveFormat.PDF);