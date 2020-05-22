import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;




public class SvgClip implements Transferable
{

    final private String svgstring;

    //https://bugs.openjdk.java.net/browse/JDK-8140526
    //http://bugs.java.com/bugdatabase/view_bug.do;jsessionid=67bf0d656b66cc60360819906ba?bug_id=4493178
    //solved!
    //http://www.javaexamples.org/java/java.awt.datatransfer/getdefaultflavormap-in-systemflavormap.html

    static final private DataFlavor svgFlavor = new DataFlavor("image/svg+xml; class=java.io.InputStream","Scalable Vector Graphic");
    static final private DataFlavor inkscapeFlavor = new DataFlavor("image/x-inkscape-svg; class=java.io.InputStream","Scalable Vector Graphic");
    //static private DataFlavor svgFlavor = new DataFlavor(String.class,"image/svg+xml");


    private DataFlavor [] supportedFlavors;
    private FileTransferable file;

    public SvgClip(String str)       
    {
        /*
        try {
            this.svgFlavor = new DataFlavor("image/svg+xml");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SvgClip.class.getName()).log(Level.SEVERE, null, ex);
        }
*/

        this.supportedFlavors = new DataFlavor[] {
            svgFlavor, 
            DataFlavor.javaFileListFlavor,
            inkscapeFlavor
        };

        this.svgstring = str;

        SystemFlavorMap systemFlavorMap = (SystemFlavorMap) SystemFlavorMap.getDefaultFlavorMap();
        DataFlavor dataFlavor = svgFlavor;
        //systemFlavorMap.addFlavorForUnencodedNative("image/svg+xml", dataFlavor);
        systemFlavorMap.addUnencodedNativeForFlavor(dataFlavor, "image/svg+xml");
        systemFlavorMap.addUnencodedNativeForFlavor(inkscapeFlavor, "image/x-inkscape-svg");

        try{
            this.file = FileTransferable.createFileInTempDirectory("temp.svg");
            List<File> files = file.getFiles();
            if(files.isEmpty())
            {
                System.out.println("No file!");
            }
            else
            {
                //write the svgstring to a file in temp.
                PrintWriter writer = new PrintWriter(files.get(0));
                writer.println(svgstring);
                writer.close();

            }
        }
        catch(Exception Ex)
        {
            Ex.printStackTrace();
        }
    }

    @Override public DataFlavor[] getTransferDataFlavors()
    {    
          return this.supportedFlavors;    
    }
    static DataFlavor getSVGFlavor()
    {
        return SvgClip.svgFlavor;
    }
    @Override public boolean isDataFlavorSupported(DataFlavor flavor)        
    {   

        for( DataFlavor supported : this.supportedFlavors)
        {
            if( flavor.equals(supported)){
                System.out.println("flavor is supported " + 
                        flavor.getMimeType()
                + " " + flavor.toString()
                        );
                return true;
            }
            else{
                System.out.println("flavor is NOT supported " + flavor.getMimeType());

            }
        }
        return false;    
    }

    @Override public Object getTransferData(DataFlavor flavor)
            throws UnsupportedFlavorException, IOException 
    {
        if (isDataFlavorSupported(flavor))
        {

            if(flavor.equals(inkscapeFlavor) || flavor.equals(svgFlavor))
            {
                InputStream stream = new ByteArrayInputStream(svgstring.getBytes(StandardCharsets.UTF_8));
                return stream;
            }
            if(flavor.equals(DataFlavor.javaFileListFlavor))
            {
                System.out.println("Returning file");
                return this.file.getTransferData(flavor);
            }
        }
        throw new UnsupportedFlavorException (flavor);
    }

    public void lostOwnership(java.awt.datatransfer.Clipboard clip,        
            java.awt.datatransfer.Transferable tr)        
    {    
        return;    
    }
}