public class EventDichiarazionePdf extends PdfPageEventHelper{
    // vvv--- Change
    public String extraValue = "";
    // ^^^--- Change
    private int numPage=0;  
    private static Font h6NormFont = new Font(Font.FontFamily.HELVETICA, 6,Font.NORMAL);    

    public void onStartPage(PdfWriter writer, Document document) {
        numPage++;
    }
    public void onEndPage(PdfWriter writer, Document document) {

         try {              
                Rectangle page = document.getPageSize(); 

                PdfPTable footer = new PdfPTable(2); 

                // vvv--- Change
                PdfPCell cellFooter = new PdfPCell( new Phrase("Something – 03/12/2016 Customer n." + extraValue ,h6NormFont)); 
                // ^^^--- Change
                cellFooter.setHorizontalAlignment(Element.ALIGN_LEFT); 
                cellFooter.setBorder(0);     
                footer.addCell(cellFooter);
                [...]
            } catch ( Exception e ) { 
                throw new ExceptionConverter( e ); 
            }          
        }
    }
}