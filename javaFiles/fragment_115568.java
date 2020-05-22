package a;
import java.io.IOException;
import org.apache.xerces.impl.XMLDocumentScannerImpl;
import org.apache.xerces.parsers.NonValidatingConfiguration;
import org.apache.xerces.xni.XMLString;
import org.apache.xerces.xni.XNIException;
import org.apache.xerces.xni.parser.XMLComponent;

public class MyConfig extends NonValidatingConfiguration {

    private MyScanner myScanner;

    @Override
    @SuppressWarnings("unchecked")
    protected void configurePipeline() {
        if (myScanner == null) {
            myScanner = new MyScanner();
            addComponent((XMLComponent) myScanner);
        }
        super.fProperties.put(DOCUMENT_SCANNER, myScanner);
        super.fScanner = myScanner;
        super.fScanner.setDocumentHandler(this.fDocumentHandler);
        super.fLastComponent = fScanner;
    }

    private static class MyScanner extends XMLDocumentScannerImpl {

        @Override
        protected void scanEntityReference() throws IOException, XNIException {
            // name
            String name = super.fEntityScanner.scanName();
            if (name == null) {
                reportFatalError("NameRequiredInReference", null);
                return;
            }

            super.fDocumentHandler.characters(new XMLString(("&" + name + ";")
                .toCharArray(), 0, name.length() + 2), null);

            // end
            if (!super.fEntityScanner.skipChar(';')) {
                reportFatalError("SemicolonRequiredInReference",
                        new Object[] { name });
            }
            fMarkupDepth--;
        }
    }

}