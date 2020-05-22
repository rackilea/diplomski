import java.awt.geom.Rectangle2D;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackagePartName;
import org.apache.poi.openxml4j.opc.PackageRelationship;
import org.apache.poi.openxml4j.opc.PackagingURIHelper;
import org.apache.poi.openxml4j.opc.TargetMode;
import org.apache.poi.xslf.usermodel.XMLSlideShow;
import org.apache.poi.xslf.usermodel.XSLFSlide;
import org.apache.poi.xslf.usermodel.XSLFTable;
import org.apache.poi.xslf.usermodel.XSLFTableCell;
import org.apache.poi.xslf.usermodel.XSLFTableRow;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlip;
import org.openxmlformats.schemas.drawingml.x2006.main.CTBlipFillProperties;
import org.openxmlformats.schemas.drawingml.x2006.main.CTRelativeRect;

public class InsertImgIntoPptxTableCell {
    // http://stackoverflow.com/questions/14495288/how-to-add-image-to-powerpoint-ppt-table-cell-using-apache-poi-hslf-xslf

    public static void main(String[] args) throws Exception {
        XMLSlideShow pptx = new XMLSlideShow();
        XSLFSlide slide = pptx.createSlide();

        // you need to include ooxml-schemas:1.1 for this to work!!!
        // otherwise an empty table will be created
        // see https://issues.apache.org/bugzilla/show_bug.cgi?id=49934
        XSLFTable table = slide.createTable();
        table.setAnchor(new Rectangle2D.Double(50, 50, 500, 20));

        XSLFTableRow row = table.addRow();
        row.addCell().setText("Cell 1");
        XSLFTableCell cell = row.addCell();
        cell.setText("Cell 2");

        CTBlipFillProperties blipPr = cell.getXmlObject().getTcPr().addNewBlipFill();
        blipPr.setDpi(72);
        // http://officeopenxml.com/drwPic-ImageData.php
        CTBlip blib = blipPr.addNewBlip();
        blipPr.addNewSrcRect();
        CTRelativeRect fillRect = blipPr.addNewStretch().addNewFillRect();
        fillRect.setL(30000);
        fillRect.setR(30000);

        PackagePartName partName = PackagingURIHelper.createPartName("/ppt/media/100px.gif");
        PackagePart part = pptx.getPackage().createPart(partName, "image/gif");
        OutputStream partOs = part.getOutputStream();
        FileInputStream fis = new FileInputStream("src/test/resources/100px.gif");
        byte buf[] = new byte[1024];
        for (int readBytes; (readBytes = fis.read(buf)) != -1; partOs.write(buf, 0, readBytes));
        fis.close();
        partOs.close();

        PackageRelationship prs = slide.getPackagePart().addRelationship(partName, TargetMode.INTERNAL, "http://schemas.openxmlformats.org/officeDocument/2006/relationships/image");

        blib.setEmbed(prs.getId());


        FileOutputStream fos = new FileOutputStream("test2.pptx");
        pptx.write(fos);
        fos.close();
    }
}