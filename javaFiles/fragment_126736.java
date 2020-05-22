import com.sun.star.beans.PropertyValue;
import com.sun.star.beans.XPropertySet;
import com.sun.star.comp.helper.Bootstrap;
import com.sun.star.comp.helper.BootstrapException;
import com.sun.star.container.XNameAccess;
import com.sun.star.frame.XComponentLoader;
import com.sun.star.graphic.XGraphic;
import com.sun.star.graphic.XGraphicProvider;
import com.sun.star.io.IOException;
import com.sun.star.lang.IllegalArgumentException;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.lang.XServiceInfo;
import com.sun.star.text.XTextDocument;
import com.sun.star.text.XTextGraphicObjectsSupplier;
import com.sun.star.uno.Exception;
import com.sun.star.uno.UnoRuntime;
import com.sun.star.uno.XComponentContext;
import com.sun.star.util.XCloseable;

public class Program {

    public static void exportGraphicObject(XGraphicProvider xGraphicProvider, XGraphic xGraphic, String fileName) throws Exception {
        if (xGraphicProvider == null){
            throw new Exception("XGraphicProvider is null.");
        }

        if (xGraphic == null){
            throw new Exception("XGraphic is null.");
        }

        PropertyValue[] properties = new PropertyValue[2];
        properties[0] = new PropertyValue();
        properties[0].Name = "URL";
        properties[0].Value = fileName;
        properties[1] = new PropertyValue();
        properties[1].Name = "MimeType";
        properties[1].Value = "image/" + fileName.trim().substring(fileName.length() - 3);

        xGraphicProvider.storeGraphic(xGraphic, properties);
    }

    public static void exportAllEmbeddedGraphics(XGraphicProvider xGraphicProvider, XTextDocument xTextDocument, String outDir) throws Exception {
        if (xGraphicProvider == null){
            throw new Exception("XGraphicProvider is null.");
        }

        if (xTextDocument == null){
            throw new Exception("XTextDocument is null.");
        }

        XTextGraphicObjectsSupplier xTextGraphicObjectsSupplier = (XTextGraphicObjectsSupplier) UnoRuntime.queryInterface(
                XTextGraphicObjectsSupplier.class, xTextDocument);

        XNameAccess xNameAccess = xTextGraphicObjectsSupplier.getGraphicObjects();
        if (xNameAccess != null && xNameAccess.hasElements()) {
            String[] names = xNameAccess.getElementNames();

            for (int i = 0; i < names.length; i++) {
                Object oGraphics = xNameAccess.getByName(names[i]);

                XServiceInfo xServiceInfo = (XServiceInfo)UnoRuntime.queryInterface(
                        XServiceInfo.class, oGraphics);
                if (xServiceInfo != null
                        && xServiceInfo.supportsService("com.sun.star.text.TextContent")
                        && xServiceInfo.supportsService("com.sun.star.text.TextGraphicObject")) {

                    XPropertySet xPropertySet = (XPropertySet)UnoRuntime.queryInterface(
                            XPropertySet.class, oGraphics);
                    String url = (String) xPropertySet.getPropertyValue("GraphicURL");

                    PropertyValue[] properties = new PropertyValue[1];
                    properties[0] = new PropertyValue();
                    properties[0].Name = "URL";
                    properties[0].Value = url;

                    XGraphic xGraphic = xGraphicProvider.queryGraphic(properties);
                    if (xGraphic != null){
                        //String fileName = UUID.randomUUID() + ".png";
                        String fileName = names[i] + ".png";
                        System.out.println("Export: " + names[i]);
                        System.out.println("Filename: " + outDir + fileName);

                        exportGraphicObject(xGraphicProvider, xGraphic, outDir + fileName);

                        xGraphic = null;
                    }

                    xServiceInfo = null;
                }

                oGraphics = null;
            }

            names = null;
            xNameAccess = null;
        }

        if (xTextGraphicObjectsSupplier != null)
            xTextGraphicObjectsSupplier = null;
    }

    public static void main(String[] args) throws Exception {
        String fileName = "file:///C:/code/_other/java-OOo/test.odt";
        String outDir = "file:///C:/code/_other/java-OOo/out/";

        XComponentContext xContext = null;
        XMultiComponentFactory xMultiComponentFactory = null;
        Object oDesktop = null;
        XComponentLoader xComponentLoader = null;
        XGraphicProvider xGraphicProvider = null;

        System.out.println("Starting OOo.");
        try {
            xContext = Bootstrap.bootstrap();
        } catch (BootstrapException e) {
            System.out.println("Boostrap failed! Failed to start OpenOffice.");
            return;
        }

        xMultiComponentFactory  = (XMultiComponentFactory) xContext.getServiceManager();
        oDesktop = xMultiComponentFactory.createInstanceWithContext(
                "com.sun.star.frame.Desktop", xContext);
        xComponentLoader = (XComponentLoader)UnoRuntime.queryInterface(
                com.sun.star.frame.XComponentLoader.class, oDesktop);
        if (xComponentLoader == null) {
            System.out.println("Failed to create XComponentLoader");
            return;
        }

        try {
            Object oGraphicProvider = xMultiComponentFactory.createInstanceWithContext(
                    "com.sun.star.graphic.GraphicProvider", xContext);
            xGraphicProvider = (XGraphicProvider) UnoRuntime.queryInterface(
                    XGraphicProvider.class, oGraphicProvider); 
        } catch (Exception e) {
            System.out.println("Failed to create XGraphicProvider!");
            return;
        }

        PropertyValue[] properties = new PropertyValue[2];
        properties[0] = new PropertyValue();
        properties[0].Name = "Hidden";
        properties[0].Value = false; // put true to hide OpenOffice window
        properties[1] = new PropertyValue();
        properties[1].Name = "CharacterSet";
        properties[1].Value = "Unicode (UTF-8)";

        XComponent document = null;
        try {
            document = xComponentLoader.loadComponentFromURL(fileName, "_blank", 0, properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        XTextDocument xTextDocument = (XTextDocument) UnoRuntime.queryInterface(
                XTextDocument.class, document);
        exportAllEmbeddedGraphics(xGraphicProvider, xTextDocument, outDir);

        XCloseable xCloseable = (XCloseable)UnoRuntime.queryInterface(
                XCloseable.class, xContext);
        if(xCloseable != null)
        {
            xCloseable.close(true);
            xCloseable = null;
        } 

        xGraphicProvider = null;
        xComponentLoader = null;
        oDesktop = null;
        xMultiComponentFactory = null;
        xContext = null;

        try {
            Runtime.getRuntime().exec("tskill soffice");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } 

        System.out.println("Done.");
    }
}