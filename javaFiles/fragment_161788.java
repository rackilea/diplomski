PdfReader pdfTemplate = new PdfReader(templateName);
ByteArrayOutputStream out = new ByteArrayOutputStream();
BaseFont unicode = BaseFont.createFont(unicodeFontPath, BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
PdfStamper stamper = new PdfStamper(pdfTemplate, out);
//assigning the font to the field
stamper.getAcroFields().setFieldProperty("myField", "textfont", unicode, null);
stamper.getAcroFields().setField("myField", someValue);
stamper.close();
pdfTemplate.close();