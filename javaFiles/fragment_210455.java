...  
import com.itextpdf.text.pdf.PdfReader;  
...  
try {  
    PdfReader pdfReader = new PdfReader( pathToUploadedPdfFile );  

    String textFromPdfFilePageOne = PdfTextExtractor.getTextFromPage( pdfReader, 1 ); 
    System.out.println( textFromPdfFilePageOne );
}  
catch ( Exception e ) {  
    // handle exception  
}