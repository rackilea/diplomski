// Creating a PdfWriter 
String dest = "C:/hellodearcode/imgtest.pdf"; 
PdfWriter writer = new PdfWriter(dest);
// Creating a PdfDocument  
PdfDocument pdfDoc = new PdfDocument(writer); 
// Creating a Document OBJECT
document = new Document(pdfDoc); 
// Creating an ImageData object 
String imageFile = "C:/hellodearcode/tabishrana-blog.jpg"; 
ImageData data = ImageDataFactory.create(imageFile);
// Creating an Image object 
Image img = new Image(data); 
// close document
document.close();