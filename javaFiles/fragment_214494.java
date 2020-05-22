import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;

//needed jars: fr.opensagres.poi.xwpf.converter.core-2.0.1.jar, 
//             fr.opensagres.poi.xwpf.converter.pdf-2.0.1.jar,
//             fr.opensagres.xdocreport.itext.extension-2.0.1.jar,
//             itext-2.1.7.jar                                  
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;

//needed jars: apache poi and it's dependencies
import org.apache.poi.xwpf.usermodel.XWPFDocument;

public class DOCXToPDFConverterSampleMin {

 public static void main(String[] args) throws Exception {

  String docPath = "./WordDocument.docx";
  String pdfPath = "./WordDocument.pdf";

  InputStream in = new FileInputStream(new File(docPath));
  XWPFDocument document = new XWPFDocument(in);
  PdfOptions options = PdfOptions.create();
  OutputStream out = new FileOutputStream(new File(pdfPath));
  PdfConverter.getInstance().convert(document, out, options);

  document.close();
  out.close();

 }
}