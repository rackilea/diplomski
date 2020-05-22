import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

...

// where you want to create the PDF;
// use a FileOutputStream for creating the PDF in the file system
// use a ByteArrayOutputStream for creating the PDF in a byte[] in memory
OutputStream output = ...; 
Document document = new Document();
PdfWriter writer = PdfWriter.getInstance(document, output);
document.open();

// Add content for the first page(s)
...
// Start e new page
document.newPage();
// Add content for the next page(s)
...
// Start a new page
document.newPage();
// etc etc

document.close();