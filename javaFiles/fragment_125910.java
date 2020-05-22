package test.java.svgspike;

import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.anim.dom.SVGOMDocument;
import org.apache.batik.anim.dom.SVGOMGElement;
import org.apache.batik.bridge.BridgeContext;
import org.apache.batik.bridge.GVTBuilder;
import org.apache.batik.bridge.UserAgentAdapter;
import org.apache.batik.gvt.GraphicsNode;
import org.apache.batik.util.XMLResourceDescriptor;

import javax.xml.xpath.XPathExpressionException;

import java.awt.geom.Point2D;
import java.awt.geom.Path2D;
import java.awt.geom.Rectangle2D;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

import com.google.common.io.Files;

import org.junit.Assert;
import org.junit.Test;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by pisarenko on 10.11.2015.
 */
public final class BatikTest {

    @Test
    public void test() throws XPathExpressionException {
        try {
            final File initialFile =
                    new File("src/test/resources/scene05_signs.svg");
            InputStream sceneFileStream = Files.asByteSource(initialFile).openStream();

            String parser = XMLResourceDescriptor.getXMLParserClassName();
            SAXSVGDocumentFactory f = new SAXSVGDocumentFactory(parser);
            String uri = "http://www.example.org/diagram.svg";
            final SVGOMDocument doc = (SVGOMDocument) f.createDocument(
                    uri, sceneFileStream);

            String viewBox = doc.getDocumentElement().getAttribute("viewBox");

            Point2D referencePoint = getReferencePoint(doc, getGroupElement(doc, "signS"));

            double signSouthX = magicallyCalculateXCoordinate(referencePoint);
            double signSouthY = magicallyCalculateYCoordinate(referencePoint, viewBox);

            Assert.assertEquals(109.675, signSouthX, 0.0000001);
            Assert.assertEquals(533.581, signSouthY, 0.0000001);

            referencePoint = getReferencePoint(doc, getGroupElement(doc, "signN"));
            Assert.assertEquals(109.906, magicallyCalculateXCoordinate(referencePoint), 0.0000001);
            Assert.assertEquals(578.293, magicallyCalculateYCoordinate(referencePoint, viewBox), 0.0000001);

            referencePoint = getReferencePoint(doc, getGroupElement(doc, "signE"));
            Assert.assertEquals(129.672, magicallyCalculateXCoordinate(referencePoint), 0.0000001);
            Assert.assertEquals(554.077, magicallyCalculateYCoordinate(referencePoint, viewBox), 0.0000001);

            referencePoint = getReferencePoint(doc, getGroupElement(doc, "signW"));
            Assert.assertEquals(93.398, magicallyCalculateXCoordinate(referencePoint), 0.0000001);
            Assert.assertEquals(553.833, magicallyCalculateYCoordinate(referencePoint, viewBox), 0.0000001);


        } catch (IOException ex) {
            Assert.fail(ex.getMessage());
        }
    }

    private SVGOMGElement getGroupElement(SVGOMDocument doc, String id){
        final NodeList nodes = doc.getDocumentElement().getElementsByTagName("g");
        SVGOMGElement signGroup = null;
        for (int i=0; (i < nodes.getLength()) && (signGroup == null); i++) {
            final Node curNode = nodes.item(i);
            final Node idNode = curNode.getAttributes().getNamedItem("id");
            if (id.equals(idNode.getTextContent())) signGroup = (SVGOMGElement) curNode;
        }
        return signGroup;
    }

    /**
     * @param doc
     * @param signGroup
     * @return the reference point, inkscape uses for group (bottom left corner of group)
     */
    private Point2D getReferencePoint(SVGOMDocument doc, SVGOMGElement signGroup){

        Point2D referencePoint = new Point2D.Double(0, 0);

        try {

            BridgeContext ctx = new BridgeContext(new UserAgentAdapter());
            new GVTBuilder().build(ctx, doc);
            GraphicsNode gvtElement = new GVTBuilder().build(ctx, signGroup);

            Rectangle2D rc = gvtElement.getSensitiveBounds();
            rc = ((Path2D) gvtElement.getTransform().createTransformedShape(rc)).getBounds2D();

          //find xMin and yMax in poi
            referencePoint = new Point2D.Double(rc.getMinX(), rc.getMaxY());

        } catch (Exception e) {
            e.printStackTrace();
        }
        return referencePoint;
    }

    /**
     * inkscape states y coordinate with origin in left bottom corner, while svg uses top left corner as origin
     * @param referencePoint bottom left corner of group
     * @param viewBox in "originX originY width height" notation
     * @return corrected y coordinate, rounded to three decimal figures (half up)
     */
    private double magicallyCalculateYCoordinate(Point2D referencePoint, String viewBox) {
        String[] viewBoxValues = viewBox.split(" ");
        BigDecimal roundedY = new BigDecimal(Double.parseDouble(viewBoxValues[3])-referencePoint.getY());
        roundedY = roundedY.setScale(3, BigDecimal.ROUND_HALF_UP);
        return roundedY.doubleValue();
    }

    /**
     * @param referencePoint bottom left corner of group
     * @return x coordinate, rounded to three decimal figures (half up)
     */
    private double magicallyCalculateXCoordinate(Point2D referencePoint) {
        BigDecimal roundedX = new BigDecimal(referencePoint.getX()).setScale(3, BigDecimal.ROUND_HALF_UP);
        return roundedX.doubleValue();
    }

}