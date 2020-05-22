import com.lowagie.text.Element;

import com.lowagie.text.pdf.BaseFont;

import com.lowagie.text.pdf.PdfContentByte;

import com.lowagie.text.pdf.PdfReader;

import com.lowagie.text.pdf.PdfStamper;



public class AddPageNumbersToExistingPageNumberPDF {



        public static void main(String[] args) {

               try {

                     PdfReader reader = new PdfReader("d:\\3\\input.pdf" );

                      int n = reader.getNumberOfPages();

                     PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(

                                   "d:\\3\\outup.pdf"));

                      int i = 0;

                     PdfContentByte pdf_over;

                     BaseFont bf = BaseFont. createFont(BaseFont.HELVETICA,

                                  BaseFont. WINANSI, BaseFont.EMBEDDED);

                      while (i < n) {

                           i++;

                           pdf_over = stamp.getOverContent(i);

                           pdf_over.beginText();

                           pdf_over.setFontAndSize(bf, 18);

                            // width,height

                           pdf_over.setTextMatrix(500, 30);

                           pdf_over.showText( "PDF-Page " + i + " of " + n);// Format your

                                                                                                              // page number

                           pdf_over.setFontAndSize(bf, 32);

                           pdf_over.showTextAligned(Element. ALIGN_LEFT, "s          s",

                                         230, 430, 45);

                           pdf_over.endText();

                     }

                     stamp.close();

              } catch (Exception de) {

                     de.printStackTrace();

              }

       }

}