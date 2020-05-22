package org.apache.poi.xssf;

import java.awt.geom.Rectangle2D;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.Set;

import javax.xml.namespace.QName;

import org.apache.poi.POIXMLDocument;
import org.apache.poi.hpsf.ClassID;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackageRelationshipTypes;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.poifs.filesystem.Ole10Native;
import org.apache.poi.poifs.filesystem.Ole10NativeException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFTextBox;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFRelation;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.XmlCursor;
import org.apache.xmlbeans.XmlException;
import org.apache.xmlbeans.XmlObject;
import org.junit.Test;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtension;
import org.openxmlformats.schemas.drawingml.x2006.main.CTOfficeArtExtensionList;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTPicture;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.CTTwoCellAnchor;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObject;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTOleObjects;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CTWorksheet;

public class TestEmbed {
    static final String drawNS = "http://schemas.microsoft.com/office/drawing/2010/main";
    static final String relationshipsNS = "http://schemas.openxmlformats.org/officeDocument/2006/relationships";

    // write some embedded objects to sheet
    @Test
    public void write() throws IOException, InvalidFormatException {
        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet sh = wb.createSheet();

        int imgPptId = addImageToWorkbook(wb, "ppt-icon.jpg", Workbook.PICTURE_TYPE_JPEG);
        int imgPckId = addImageToWorkbook(wb, "PackageIcon.png", Workbook.PICTURE_TYPE_PNG);

        String imgPckRelId = addImageToSheet(sh, imgPckId, Workbook.PICTURE_TYPE_PNG);
        String imgPptRelId = addImageToSheet(sh, imgPptId, Workbook.PICTURE_TYPE_JPEG);

        // embed two different HTML pages via package manager
        XSSFClientAnchor imgAnchor1 = new XSSFClientAnchor(0, 0, 0, 0, 1, 1, 3, 3);
        String oleRelId1 = addHtml(sh, 1);
        int shapeId1 = addImageToShape(sh, imgAnchor1, imgPckId);
        addObjectToShape(sh, imgAnchor1, shapeId1, oleRelId1, imgPckRelId, "Objekt-Manager-Shellobjekt");

        XSSFClientAnchor imgAnchor2 = new XSSFClientAnchor(0, 0, 0, 0, 5, 1, 7, 3);
        String oleRelId2 = addHtml(sh, 2);
        int shapeId2 = addImageToShape(sh, imgAnchor2, imgPckId);
        addObjectToShape(sh, imgAnchor2, shapeId2, oleRelId2, imgPckRelId, "Objekt-Manager-Shellobjekt");

        // embed a slideshow (no package manager needed)
        XSSFClientAnchor imgAnchor3 = new XSSFClientAnchor(0, 0, 0, 0, 1, 5, 7, 10);
        String oleRelId3 = addSlideShow(sh, 1);
        int shapeId3 = addImageToShape(sh, imgAnchor3, imgPptId);
        addObjectToShape(sh, imgAnchor3, shapeId3, oleRelId3, imgPptRelId, "Presentation");


        FileOutputStream fos = new FileOutputStream("bla.xlsx");
        wb.write(fos);
        fos.close();

        wb.close();
    }

    // read Ole10Native objects from workbook
    @Test
    public void read() throws IOException, XmlException, Ole10NativeException {
        XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("bla.xlsx"));
        XSSFSheet sheet = wb.getSheetAt(0);
        CTWorksheet cws = sheet.getCTWorksheet();
        if (!cws.isSetOleObjects()) {
            System.out.println("sheet has no ole objects");
        } else {
            Set<Integer> processedShapes = new HashSet<Integer>();
            for (XmlObject xOleObj : cws.getOleObjects().selectPath("declare namespace p='"+XSSFRelation.NS_SPREADSHEETML+"' .//p:oleObject")) {
                XmlCursor cur = xOleObj.newCursor();
                String shapeId = cur.getAttributeText(new QName("shapeId"));
                String relId = cur.getAttributeText(new QName(relationshipsNS, "id"));
                cur.dispose();

                if (processedShapes.contains(Integer.valueOf(shapeId))) {
                    continue;
                }
                processedShapes.add(Integer.valueOf(shapeId));

                PackagePart pp = sheet.getRelationById(relId).getPackagePart();
                if ("application/vnd.openxmlformats-officedocument.oleObject".equals(pp.getContentType())) {
                    InputStream is = pp.getInputStream();
                    POIFSFileSystem poifs = new POIFSFileSystem(is);
                    is.close();
                    Ole10Native ole10 = Ole10Native.createFromEmbeddedOleObject(poifs);
                    poifs.close();
                    System.out.println("Filename: "+ole10.getFileName()+" - content length: "+ole10.getDataSize());
                }
            }

        }
        wb.close();
    }



    // add a dummy html to the embeddings folder
    private static String addHtml(XSSFSheet sh, int oleId) throws IOException, InvalidFormatException {
        String html10 = "<html><body><marquee>This is the end. Html-id: "+oleId+"</marquee></body></html>";
        Ole10Native ole10 = new Ole10Native("html"+oleId+".html", "html"+oleId+".html", "html"+oleId+".html", html10.getBytes("ISO-8859-1"));

        ByteArrayOutputStream bos = new ByteArrayOutputStream(500);
        ole10.writeOut(bos);

        POIFSFileSystem poifs = new POIFSFileSystem();
        poifs.getRoot().createDocument(Ole10Native.OLE10_NATIVE, new ByteArrayInputStream(bos.toByteArray()));

        poifs.getRoot().setStorageClsid(ClassID.OLE10_PACKAGE);


        final PackagePartName pnOLE = PackagingURIHelper.createPartName( "/xl/embeddings/oleObject"+oleId+".bin" );
        final PackagePart partOLE = sh.getWorkbook().getPackage().createPart( pnOLE, "application/vnd.openxmlformats-officedocument.oleObject" );
        PackageRelationship prOLE = sh.getPackagePart().addRelationship( pnOLE, TargetMode.INTERNAL, POIXMLDocument.OLE_OBJECT_REL_TYPE );
        OutputStream os = partOLE.getOutputStream();
        poifs.writeFilesystem(os);
        os.close();
        poifs.close();

        return prOLE.getId();
    }


    // add a dummy slideshow to the embeddings folder
    private static String addSlideShow(XSSFSheet sh, int pptId) throws IOException, InvalidFormatException {
        XMLSlideShow ppt = new XMLSlideShow();
        XSLFTextBox tb = ppt.createSlide().createTextBox();
        tb.setText("this is the end - PPT-ID: "+pptId);
        tb.setAnchor(new Rectangle2D.Double(100,100,100,100));

        final PackagePartName pnPPT = PackagingURIHelper.createPartName( "/xl/embeddings/sample"+pptId+".pptx" );
        final PackagePart partPPT = sh.getWorkbook().getPackage().createPart( pnPPT, "application/vnd.openxmlformats-officedocument.presentationml.presentation" );
        PackageRelationship prPPT = sh.getPackagePart().addRelationship( pnPPT, TargetMode.INTERNAL, POIXMLDocument.PACK_OBJECT_REL_TYPE );
        OutputStream os = partPPT.getOutputStream();
        ppt.write(os);
        os.close();
        ppt.close();

        return prPPT.getId();
    }



    private static int addImageToWorkbook(XSSFWorkbook wb, String fileName, int pictureType) throws IOException {
        FileInputStream fis = new FileInputStream(fileName);
        int imgId = wb.addPicture(fis, pictureType);
        fis.close();
        return imgId;
    }

    private static String addImageToSheet(XSSFSheet sh, int imgId, int pictureType) throws InvalidFormatException {
        final PackagePartName pnIMG  = PackagingURIHelper.createPartName( "/xl/media/image"+(imgId+1)+(pictureType == Workbook.PICTURE_TYPE_PNG ? ".png" : ".jpeg") );
        PackageRelationship prIMG = sh.getPackagePart().addRelationship( pnIMG, TargetMode.INTERNAL, PackageRelationshipTypes.IMAGE_PART );
        return prIMG.getId();
    }


    private static int addImageToShape(XSSFSheet sh, XSSFClientAnchor imgAnchor, int imgId) {
        XSSFDrawing pat = sh.createDrawingPatriarch();
        XSSFPicture pic = pat.createPicture(imgAnchor, imgId);

        CTPicture cPic = pic.getCTPicture();
        int shapeId = (int)cPic.getNvPicPr().getCNvPr().getId();
        cPic.getNvPicPr().getCNvPr().setHidden(true);
        CTOfficeArtExtensionList extLst = cPic.getNvPicPr().getCNvPicPr().addNewExtLst();
        // https://msdn.microsoft.com/en-us/library/dd911027(v=office.12).aspx
        CTOfficeArtExtension ext = extLst.addNewExt();
        ext.setUri("{63B3BB69-23CF-44E3-9099-C40C66FF867C}");
        XmlCursor cur = ext.newCursor();
        cur.toEndToken();
        cur.beginElement(new QName(drawNS, "compatExt", "a14"));
        cur.insertAttributeWithValue("spid", "_x0000_s"+shapeId);


        return shapeId;
    }



    private static void addObjectToShape(XSSFSheet sh, XSSFClientAnchor imgAnchor, int shapeId, String objRelId, String imgRelId, String progId) {
        CTWorksheet cwb = sh.getCTWorksheet();
        CTOleObjects oo = cwb.isSetOleObjects() ? cwb.getOleObjects() : cwb.addNewOleObjects();

        CTOleObject ole1 = oo.addNewOleObject();
        ole1.setProgId(progId);
        ole1.setShapeId(shapeId);
        ole1.setId(objRelId);


        XmlCursor cur1 = ole1.newCursor();
        cur1.toEndToken();
        cur1.beginElement("objectPr", XSSFRelation.NS_SPREADSHEETML);
        cur1.insertAttributeWithValue("id", relationshipsNS, imgRelId);
        cur1.insertAttributeWithValue("defaultSize", "0");
        cur1.beginElement("anchor", XSSFRelation.NS_SPREADSHEETML);
        cur1.insertAttributeWithValue("moveWithCells", "1");

        CTTwoCellAnchor anchor = CTTwoCellAnchor.Factory.newInstance();
        anchor.setFrom(imgAnchor.getFrom());
        anchor.setTo(imgAnchor.getTo());

        XmlCursor cur2 = anchor.newCursor();
        cur2.copyXmlContents(cur1);
        cur2.dispose();

        cur1.toParent();
        cur1.toFirstChild();
        cur1.setName(new QName(XSSFRelation.NS_SPREADSHEETML, "from"));
        cur1.toNextSibling();
        cur1.setName(new QName(XSSFRelation.NS_SPREADSHEETML, "to"));

        cur1.dispose();
    }
}