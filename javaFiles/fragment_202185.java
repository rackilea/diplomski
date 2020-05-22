PDDocument pdDocument = PDDocument.load(resource);
PDPage page = pdDocument.getPage(12-1);
page.setCropBox(new PDRectangle(40f, 680f, 510f, 100f));

PDFRenderer renderer = new PDFRenderer(pdDocument);
BufferedImage img = renderer.renderImage(12 - 1, 4f);
ImageIOUtil.writeImage(img, new File(RESULT_FOLDER, "ENG-US_NMATSCJ-1.103-0330-page12cropped.jpg").getAbsolutePath(), 300);
pdDocument.close();