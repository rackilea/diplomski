import org.apache.poi.POIXMLDocumentPart;
import org.apache.poi.openxml4j.opc.*;
import org.apache.poi.xssf.usermodel.*;
import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.*;

public class Images2Cells {
    public static void main(String[] args) throws Exception {
        OPCPackage opc = OPCPackage.open("auto.xlsx", PackageAccess.READ);
        XSSFWorkbook book = new XSSFWorkbook(opc);

        XSSFSheet sheet = book.getSheetAt(0);
        for (POIXMLDocumentPart pdp : sheet.getRelations()) {
            if (!XSSFRelation.DRAWINGS.getRelation().equals(pdp.getPackageRelationship().getRelationshipType())) continue;

            PackagePart drawPP = pdp.getPackagePart();
            WsDrDocument draw = WsDrDocument.Factory.parse(drawPP.getInputStream());

            for (CTOneCellAnchor oneAnc : draw.getWsDr().getOneCellAnchorList()) {
                String picId = oneAnc.getPic().getBlipFill().getBlip().getEmbed();
                PackageRelationship pr = drawPP.getRelationship(picId);
                PackagePart imgPP = drawPP.getRelatedPart(pr);
                // byte imgBytes[] = IOUtils.toByteArray(imgPP.getInputStream());

                System.out.println(imgPP.getPartName()
                    +" - Col: "+oneAnc.getFrom().getCol()
                    +" - Row: "+oneAnc.getFrom().getRow()
                );
            }

            for (CTTwoCellAnchor twoAnc : draw.getWsDr().getTwoCellAnchorList()) {
                String picId = twoAnc.getPic().getBlipFill().getBlip().getEmbed();
                PackageRelationship pr = drawPP.getRelationship(picId);
                PackagePart imgPP = drawPP.getRelatedPart(pr);

                System.out.println(imgPP.getPartName()
                    +" - Col1: "+twoAnc.getFrom().getCol()
                    +" - Row1: "+twoAnc.getFrom().getRow()
                    +" - Col2: "+twoAnc.getTo().getCol()
                    +" - Row2: "+twoAnc.getTo().getRow()
                );
            }
        }

        opc.revert();
    }
}