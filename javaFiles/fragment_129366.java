File image = convertMultipartFileToFile(file);
BufferedImage awtImage = ImageIO.read(image);

// check if horizontal or vertical
Boolean isHorizontal = false;
if (awtImage.getWidth() > awtImage.getHeight()) {
    isHorizontal = true;
}
String path = "";

// get actual height and width of pdf page 'cause pdfbox sees page always as vertical and only saves the rotation   
// ....-------------------
// ...|...................|
// ...|.........A4........|...0.x
// ...|......PDF.page.....|..0y-|----------------------------
// ...|......vertical.....|.....|............A4..............|
// ...|...._________......|.....|.........PDF.page...........|
// ...|...(.........).....|.....|........horizontal..........|
// ...|...(..image..).....|.....|...._______________.........|
// ...|...(.........).....|.....|...(...............)........|
// ...|...(.........).....|.....|...(....image......)........|
// ...|...(.........).....|.....|...(_______________)........|
// ...|...(_________).....|.....|----------------------------
// 0x-|-------------------
// ..0y
int actualPDFWidth = 0;
int actualPDFHeight = 0;
if (isHorizontal) {
    actualPDFWidth = (int) PDRectangle.A4.getHeight();
    actualPDFHeight = (int) PDRectangle.A4.getWidth();
    path = MyController.class.getResource("/pdf4ImageUploadHorizontal.pdf").getPath();
} else {
    actualPDFWidth = (int) PDRectangle.A4.getWidth();
    actualPDFHeight = (int) PDRectangle.A4.getHeight();
    path = MyController.class.getResource("/pdf4ImageUploadVertical.pdf").getPath();
}

pdf = new File(path);
PDDocument doc = PDDocument.load(pdf);
PDPage page = doc.getPage(0);

PDImageXObject pdImage = PDImageXObject.createFromFileByContent(image, doc);
PDPageContentStream contentStream = new PDPageContentStream(doc, page);

// scale image
Dimension scaledDim = getScaledDimension(new Dimension(pdImage.getWidth(), pdImage.getHeight()), new Dimension(actualPDFWidth, actualPDFHeight)); // I'm using this function: https://stackoverflow.com/questions/23223716/scaled-image-blurry-in-pdfbox

// if horizontal rotate 90°, calculate position and draw on page
if (isHorizontal) {
    int x = (int) PDRectangle.A4.getWidth() - (((int) PDRectangle.A4.getWidth() - scaledDim.height) /2);
    int y = ((int) PDRectangle.A4.getHeight() - scaledDim.width) / 2;
    AffineTransform at = new AffineTransform(scaledDim.getHeight(), 0, 0, scaledDim.getWidth(), x, y);
    at.rotate(Math.toRadians(90));
    Matrix m = new Matrix(at);
    contentStream.drawImage(pdImage, m);
} else {
    int x = ((int) PDRectangle.A4.getWidth() - scaledDim.width) / 2;
    int y = ((int) PDRectangle.A4.getHeight() - scaledDim.height) / 2;
    contentStream.drawImage(pdImage, x, y, scaledDim.width, scaledDim.height);
}

contentStream.close();
doc.save("c:\\xyz\\pdf.pdf");           
doc.close();