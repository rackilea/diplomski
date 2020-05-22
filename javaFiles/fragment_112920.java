public class FlyingSaucer2PDF {
public static final String HTML = "output.html";
public static final String PDF = "C:\\Temp\\Tested.pdf";

public static void main(String[] args) {
    // TODO Auto-generated method stub
    FlyingSaucer2PDF f = new FlyingSaucer2PDF();
    try {
        f.printPdf();
        f.print(null);
    } catch (DocumentException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (PrintException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}

public void printPdf() throws DocumentException, IOException {
    String url = new File(HTML).toURI().toURL().toString();
    OutputStream os = new FileOutputStream(PDF);

    ITextRenderer renderer = new ITextRenderer();
    renderer.setDocument(url);
    renderer.layout();
    renderer.createPDF(os);

    os.close();
}

public void print(File file) throws FileNotFoundException, PrintException {
    PrinterService ps = new PrinterService();
    // get the printer service by printer name
    PrintService pss = PrintServiceLookup.lookupDefaultPrintService();// ps.getCheckPrintService("Samsung ML-2850 Series PCL6 Class Driver");
    System.out.println("Printer - " + pss.getName());
    DocPrintJob job = pss.createPrintJob();
    DocAttributeSet das = new HashDocAttributeSet();
    Doc document = new SimpleDoc(new FileInputStream(new File(PDF)), DocFlavor.INPUT_STREAM.AUTOSENSE, das);
    // new htmldo
    PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
    job.print(document, pras);
}