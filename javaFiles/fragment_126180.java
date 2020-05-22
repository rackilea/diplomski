...
byte inputBytes[] = IOUtils.toByteArray(inputStream);
PDDocument pdDocument = PDDocument.load(new ByteArrayInputStream(inputBytes));

PDJpeg ximage = new PDJpeg(pdDocument, ImageIO.read(logoStream));
PDPage page = (PDPage) pdDocument.getDocumentCatalog().getAllPages().get(0);
PDPageContentStream contentStream = new PDPageContentStream(pdDocument, page, true, true);
contentStream.drawXObject(ximage, 50, 50, 356, 40);
contentStream.close();

page.getResources().getCOSObject().setNeedToBeUpdate(true);
page.getResources().getCOSDictionary().getDictionaryObject(COSName.XOBJECT).setNeedToBeUpdate(true);
ximage.getCOSObject().setNeedToBeUpdate(true);

PDSignature signature = new PDSignature();
...