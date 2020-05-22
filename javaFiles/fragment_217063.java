PdfDocument doc = new PdfDocument();

// Read the image as BufferedImage object
BufferedImage bufImg = ImageIO.read(new File(
    "SampleImage.PNG"));

// Create PdfImage object using the above BufferedImage object
PdfImage img = PdfImage.create(bufImg);

// Create a PdfPage of image size (image width x image Height)
PdfPage page1 = new PdfPage(img.width(), img.height());

// draw the image at 0, 0
page1.drawImage(img, 0, 0);

// add the page to the document object
doc.add(page1);

// save the document to the output file
doc.save("PNGImageToPDF.pdf");
doc.close();