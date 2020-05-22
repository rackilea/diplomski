PdfPage page = iTextPdfDoc.getLastPage();
PdfCanvas pdfCanvas = new PdfCanvas(page.newContentStreamAfter(), 
page.getResources(), iTextPdfDoc);
Canvas canvas = new Canvas(pdfCanvas, iTextPdfDoc, page.getPageSize());
Image img = new Image(ImageDataFactory.create(path));

float width = img.getXObject().getWidth();
float widthContainer = 525.58203;
float heightContainer = 737.0079;
float horizontalScaling = widthContainer / width;

img.scaleAbsolute(widthContainer, heightContainer);

img.setProperty(Property.ROTATION_ANGLE, Math.toRadians(270));
img.setFixedPosition(imageLlx, imageLly + width * horizontalScaling);

canvas.add(img);