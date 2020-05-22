public class PdfExporter
    //a custom class to build content

    //create some content to add to pdf
    String text = "<div>Lots of important content here</div>";

    //assume the section is known to be deleted
    if(section_deleted) {
        //add a special marker to the text, in white-on-white
        text = "<span style=\"color:white;\">.!^DEL^?.</span>" + text + "</span>";
    } 

    //based on some indicator, we know we want to force a new page for a new section
    boolean ensureNewPage = true;

    //use an instance of PdfDocHandler to add the content
    pdfDocHandler.addText(text, ensureNewPage); 




public class PdfDocHandler extends PdfPageEventHelper
    private boolean isDEL;

    public boolean addText(String text, boolean ensureNewPage)

       if (ensureNewPage) {     
           //turn isDEL off: a forced pagebreak indicates a new section
           isDEL = false;
       }

        //attempt to find the special DELETE marker in first chunk
        //NOTE: this can be done several ways
        ArrayList<Chunk> chks = elem.getChunks();
        if(chks.size()>0) {
            if(chks.get(0).getContent().contains(".!^DEL^?.")) {
                //special delete marker found in text
                isDEL = true;
            }
        }

        //doc is an iText Document
        doc.add(elem);


    public void onEndPage(PdfWriter writer, Document document) {

        if(isDEL) {
            //set the watermark
            Phrase watermark = new Phrase("DELETED", new Font(Font.FontFamily.HELVETICA, 60, Font.NORMAL, BaseColor.PINK));
            PdfContentByte canvas = writer.getDirectContentUnder();
            ColumnText.showTextAligned(canvas, Element.ALIGN_CENTER, watermark, 298, 421, 45);   
        }
    }