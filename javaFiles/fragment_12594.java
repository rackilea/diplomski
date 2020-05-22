package com.newgen.doc;

import com.sun.star.awt.Point;
import com.sun.star.awt.Size;
import com.sun.star.beans.PropertyValue;
import com.sun.star.beans.XPropertySet;
import com.sun.star.bridge.XUnoUrlResolver;
import com.sun.star.comp.helper.Bootstrap;
import com.sun.star.container.XNameContainer;
import com.sun.star.drawing.XShape;
import com.sun.star.frame.XComponentLoader;
import com.sun.star.frame.XController;
import com.sun.star.frame.XStorable;
import com.sun.star.io.IOException;
import com.sun.star.lang.XComponent;
import com.sun.star.lang.XMultiComponentFactory;
import com.sun.star.lang.XMultiServiceFactory;
import com.sun.star.text.XPageCursor;
import com.sun.star.text.XText;
import com.sun.star.text.XTextContent;
import com.sun.star.text.XTextCursor;
import com.sun.star.text.XTextDocument;
import com.sun.star.text.XTextRange;
import com.sun.star.text.XTextViewCursor;
import com.sun.star.text.XTextViewCursorSupplier;
import com.sun.star.uno.UnoRuntime;

import com.sun.star.uno.XComponentContext;
import com.sun.star.uno.XInterface;
import com.sun.star.util.CloseVetoException;
import com.sun.star.util.XCloseable;
import com.sun.star.util.XReplaceDescriptor;
import com.sun.star.util.XReplaceable;
import com.sun.star.util.XSearchDescriptor;
import com.sun.star.util.XSearchable;


public class GenerateDocWithSignature {
    public static void main(String args[]) {
        String templateUrl = "File:///C:/temp/Test.odt";
        String signatureImg = "file:///C:/temp/signature.jpg";
        GenerateDocWithSignature graphicExample = new GenerateDocWithSignature();
        boolean pdfFlag = true;
        try {
            graphicExample.addSignature(templateUrl, signatureImg, pdfFlag);
        } catch (java.lang.Exception e) {
            System.out.println("Please check Exception::" + e);            
        } finally {
            System.exit(0);
        }
    }

    protected void addSignature(String templateUrl, String signatureImg, boolean pdfFlag) {
        XMultiComponentFactory xRemoteServiceManager = null;
        XTextRange xTextRange = null;
        XTextViewCursorSupplier supTextViewCursor = null;
        XController xController = null;
        Object obj = null;
        XComponent xComp = null;

        String openOfficePort = "8100";//"2001";
        String conDesc = "uno:socket,host=localhost,port=" + openOfficePort + ";urp;StarOffice.ServiceManager";
        XComponentContext xContext = getXComponentContext();
        xRemoteServiceManager = xContext.getServiceManager();
        try {
            obj = xRemoteServiceManager.createInstanceWithContext("com.sun.star.bridge.UnoUrlResolver", xContext);
            XUnoUrlResolver xUnoUrlResolver = (XUnoUrlResolver) UnoRuntime.queryInterface(XUnoUrlResolver.class, obj);
            obj = xUnoUrlResolver.resolve(conDesc);
            xRemoteServiceManager = (XMultiComponentFactory) UnoRuntime.queryInterface(XMultiComponentFactory.class, obj);

            Object desktop = xRemoteServiceManager.createInstanceWithContext("com.sun.star.frame.Desktop", xContext);
            XComponentLoader xComponentLoader = (XComponentLoader) UnoRuntime.queryInterface(XComponentLoader.class, desktop);

            PropertyValue[] loadProps = new PropertyValue[1];
            loadProps[0] = new PropertyValue();
            loadProps[0].Name = "Hidden";
            loadProps[0].Value = true;

            xComp = xComponentLoader.loadComponentFromURL(templateUrl, "_blank", 0, loadProps);

        }catch(Exception e){
            System.out.println("Exception::"+e);
        }

        // Get XTextDocument from template
        XTextDocument xTextDoc = (XTextDocument) UnoRuntime.queryInterface(XTextDocument.class, xComp);

        // Get Current Controller
        xController = xTextDoc.getCurrentController();
        supTextViewCursor = (XTextViewCursorSupplier) UnoRuntime.queryInterface(XTextViewCursorSupplier.class, xController);
        XTextViewCursor curTextView = supTextViewCursor.getViewCursor();

        // Get page cursor and assigns XTextViewCursor cursor to page
        XPageCursor curPage = (XPageCursor) UnoRuntime.queryInterface(XPageCursor.class, curTextView);
        System.out.println("The current page number is " + curPage.getPage());

        // Querying for the interface XMultiServiceFactory on the XTextDocument
        XMultiServiceFactory xMSFDoc = (XMultiServiceFactory) UnoRuntime.queryInterface(XMultiServiceFactory.class, xTextDoc);

        // Get XText
        XText xText = xTextDoc.getText();

        XReplaceDescriptor xReplaceDescr = null;
        XSearchDescriptor xSearchDescr = null;
        XReplaceable xReplaceable = null;
        XSearchable xSearchable = null;
        XStorable xStorable = null;
        xReplaceable = (XReplaceable) UnoRuntime.queryInterface(XReplaceable.class, xTextDoc);
        xReplaceDescr = xReplaceable.createReplaceDescriptor();
        xSearchable = (XSearchable) UnoRuntime.queryInterface(XSearchable.class, xTextDoc);
        xSearchDescr = xSearchable.createSearchDescriptor();
        xSearchDescr.setSearchString("Signature");
        Point point = null;
        // Search String and get its first occurrence and get  XInterface
        XInterface xInterface = (XInterface) xSearchable.findFirst(xSearchDescr);
        System.out.println("XInterface=" + xInterface);
        if (xInterface != null) {
            System.out.println("XInterface-->" + xInterface.toString());
            xTextRange = (com.sun.star.text.XTextRange) UnoRuntime.queryInterface(
                    com.sun.star.text.XTextRange.class, xInterface);
            System.out.println("xTextRange-->" + xTextRange.getString());
            curTextView.gotoRange(xTextRange, false);

            //get cursor position
            point = curTextView.getPosition();
            System.out.println("Point X=" + point.X + " Y=" + point.Y);
        }

        XTextCursor xTextCursor = (com.sun.star.text.XTextCursor) UnoRuntime.queryInterface(
                com.sun.star.text.XTextCursor.class, xInterface);

        try {
            // Creating graphic shape service
            Object graphicObjShape = null;
            graphicObjShape = xMSFDoc.createInstance("com.sun.star.drawing.GraphicObjectShape");

            // Customizing graphic shape position and size
            XShape shapeSettings = (XShape) UnoRuntime.queryInterface(XShape.class, graphicObjShape);
            shapeSettings.setSize(new Size(600, 600));
        //shapeSettings.setPosition(point);

            // Creating bitmap container service
            XNameContainer bitmapContainer = UnoRuntime.queryInterface(XNameContainer.class,
                    xMSFDoc.createInstance("com.sun.star.drawing.BitmapTable"));
            // Inserting test image to the container
            bitmapContainer.insertByName("Signature", signatureImg);
            // Querying for the interface XPropertySet on the graphic object
            XPropertySet xPropSet = (XPropertySet) UnoRuntime.queryInterface(XPropertySet.class, graphicObjShape);

            System.out.println("Test img url is" + bitmapContainer.getByName("Signature"));

            // Setting Signature image internal URL to graphic shape property
            xPropSet.setPropertyValue("GraphicURL", bitmapContainer.getByName("Signature"));

            // Convert graphic shape to the text content item
            XTextContent xTextContent = (XTextContent) UnoRuntime.queryInterface(XTextContent.class, graphicObjShape);

            // Embed image into the document text with replacement
            System.out.println("Inserting image...");
            xText.insertTextContent(xTextCursor, xTextContent, true);

        } catch (Exception e) {
            System.out.println("Exception::" + e);
        }

        //close
        PropertyValue[] storeProps = null;
        String fileName = null;
        String newFileName = null;
        try {
            xStorable = (XStorable) UnoRuntime.queryInterface(XStorable.class, xTextDoc);
            if (!pdfFlag) {
                if (templateUrl.substring(templateUrl.lastIndexOf('.') + 1).equalsIgnoreCase("doc")) {
                    xStorable.store();
                } else {
                    fileName = templateUrl.substring(0, templateUrl.lastIndexOf('.'));
                    storeProps = new PropertyValue[1];
                    storeProps[0] = new PropertyValue();
                    storeProps[0].Name = "FilterName";
                    storeProps[0].Value = "MS Word 97";
                    xStorable.storeToURL(fileName + ".doc", storeProps);
                    newFileName = fileName + ".doc";
                }
            } else {
                fileName = templateUrl.substring(0, templateUrl.lastIndexOf('.'));
                storeProps = new PropertyValue[1];
                storeProps[0] = new PropertyValue();
                storeProps[0].Name = "FilterName";
                storeProps[0].Value = "writer_pdf_Export";
                xStorable.storeToURL(fileName + ".pdf", storeProps);
                newFileName = fileName + ".pdf";
            }
            System.out.println("Document generated-->" + newFileName);
            XCloseable xCloseable = (XCloseable) UnoRuntime.queryInterface(XCloseable.class, xTextDoc);
            xCloseable.close(true);
        } catch (IOException | CloseVetoException e) {
            System.out.println("Exception::"+e);
        }
    }


    private XComponentContext getXComponentContext() {
        XComponentContext xContext = null;
        XMultiComponentFactory xRemoteServiceManager = null;

        String openOfficePort = "";

        try {
            xContext = Bootstrap.createInitialComponentContext(null);
            System.out.println("xContext=" + xContext);
            openOfficePort = "8100";//"2001";

            String DefCon = "uno:socket,host=localhost,port=" + openOfficePort + ";urp;StarOffice.ServiceManager";

            xRemoteServiceManager = xContext.getServiceManager();

            Object obj = xRemoteServiceManager.createInstanceWithContext("com.sun.star.bridge.UnoUrlResolver", xContext);
            XUnoUrlResolver xUnoUrlResolver = (XUnoUrlResolver) UnoRuntime.queryInterface(XUnoUrlResolver.class, obj);

            obj = xUnoUrlResolver.resolve(DefCon);

            xRemoteServiceManager = (XMultiComponentFactory) UnoRuntime.queryInterface(XMultiComponentFactory.class, obj);
            XPropertySet xPropertySet = (XPropertySet) UnoRuntime.queryInterface(XPropertySet.class, xRemoteServiceManager);

            obj = xPropertySet.getPropertyValue("DefaultContext");
            xContext = (XComponentContext) UnoRuntime.queryInterface(XComponentContext.class, obj);
        } catch (Exception e) {
            System.out.println("Exception::"+e);
        }
        System.out.println("xContext="+xContext);
        return xContext;
    }

}