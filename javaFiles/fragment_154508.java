import java.io.File;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.Iterator;
    import java.util.List;
    import java.util.Map;
    import java.util.Map.Entry;

    import org.apache.pdfbox.pdmodel.PDDocument;
    import org.apache.pdfbox.pdmodel.PDPage;
    import org.apache.pdfbox.pdmodel.common.PDRectangle;
    import org.apache.pdfbox.pdmodel.interactive.action.PDAction;
    import org.apache.pdfbox.pdmodel.interactive.action.PDActionGoTo;
    import org.apache.pdfbox.pdmodel.interactive.annotation.PDAnnotationLink;
    import org.apache.pdfbox.pdmodel.interactive.annotation.PDBorderStyleDictionary;
    import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDDocumentOutline;
    import org.apache.pdfbox.pdmodel.interactive.documentnavigation.outline.PDOutlineItem;
    import org.apache.pdfbox.text.PDFTextStripper;

    /**
     * @author micky
     *
     * The class merges PDF files
     *  - one file with item details info
     *  - one or more files with items diagrams
     *  
     *   Purpose is to merge diagram files into item details file and create links 
     *   from the items in diagrams to item details
     */
    public class PDFReportHyperlinks {

         public static void main(String[] args){

             PDDocument reportDocument = null;
             try {

                 String reportFileName = "D:/ItemsDetails.pdf";

                 Map<String, PDAction> actionsMap = new HashMap<String, PDAction>();
                 reportDocument = PDDocument.load(new File(reportFileName));

                 // Get the bookmarks i.e. existing GoTo actions
                 PDDocumentOutline bookmarks = reportDocument.getDocumentCatalog().getDocumentOutline();
                 PDOutlineItem item = bookmarks.getFirstChild();
                 while(item != null ){
                     actionsMap.put(item.getTitle(), item.getAction());
                     item = item.getNextSibling();
                 }

                 // Diagram files, they have single page
                 List diagamFiles = new ArrayList<String>() {{
                        add("D:/Diagram_1.pdf");
                        add("D:/Diagram_2.pdf");
                        add("D:/Diagram_3.pdf");
                 }};

                 Iterator diagramsIt = diagamFiles.iterator();
                 while (diagramsIt.hasNext()) {
                     String diagramName = (String) diagramsIt.next();

                     //--<Import diagram>---------------------------------
                     PDDocument sourceDocument = PDDocument.load(new File(diagramName));
                     PDPage pp = (PDPage) sourceDocument .getDocumentCatalog().getPages().get(0);
                     PDPage page = reportDocument.importPage(pp);

                     //--<Create links from diagrams to objects>---------------------------------

                     // TextStripper is separate class extending PDFTextStripper
                     // It is searching for items names and returning Map with their coordinates
                     TextStripper stripper = new TextStripper(sourceDocument,
                             new ArrayList<String>() {{
                                 add("Item1_Name");
                                 add("Item2_Name");
                                 add("Item3_Name");
                                 add("Item4_Name");
                                 add("Item5_Name");
                             }});

                     Map<String, float[]> objCoordinates = stripper.getObjCoordinates();

                     Iterator entries = objCoordinates.entrySet().iterator();
                     while (entries.hasNext()) {
                         Entry entry = (Entry) entries.next();
                         String key = (String) entry.getKey();

                         PDAnnotationLink txtLink = new PDAnnotationLink();
                         PDBorderStyleDictionary borderULine = new PDBorderStyleDictionary();
                         borderULine.setWidth(0);
                         txtLink.setBorderStyle(borderULine);
                         PDActionGoTo action = (PDActionGoTo) actionsMap.get(key);
                         txtLink.setAction(action);

                         final float[] quads = (float[]) entry.getValue();
                         PDRectangle rect = new PDRectangle();
                         rect.setLowerLeftX(quads[0]);
                         rect.setLowerLeftY(quads[5]);
                         rect.setUpperRightX(quads[2]);
                         rect.setUpperRightY(quads[1]);
                         txtLink.setRectangle(rect);

                         page.getAnnotations().add(txtLink);
                     }

                     //--<Create bookmarks for new pages (diagrams)>---------------------------------
                     PDOutlineItem menuItem = new PDOutlineItem();
                     menuItem.setTitle(diagramName);
                     menuItem.setDestination(page);
                     bookmarks.addLast(menuItem);
                     menuItem.openNode();
                     bookmarks.openNode();

                 }

                 reportDocument.save(new File(reportFileName));
                 reportDocument.close();

                 // Alternative merging documents example not feasible in this case
                 //PDFMergerUtility ut = new PDFMergerUtility();
                 //ut.addSource(reportFileName);
                 //diagramsIt = diagamFiles.iterator();
                 //while (diagramsIt.hasNext()) {
                 //  String diagramName = (String) diagramsIt.next();
                 //  ut.addSource(diagramName);
                 // }
                 //ut.setDestinationFileName(reportFileName);
                 //ut.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

                System.out.println("COMPLETED");

             } catch (Exception e) {
                 System.out.println(e);
             } finally {
                 try {
                     reportDocument.close();
                 } catch (Exception e) {
                     System.out.println(e);
                 }
            }
        }
    }