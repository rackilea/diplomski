import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xslf.usermodel.*;
import org.apache.poi.sl.usermodel.*;

import org.apache.poi.POIXMLDocumentPart;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.openxml4j.opc.PackagePart;
import org.apache.poi.openxml4j.opc.PackageRelationshipCollection;
import org.apache.poi.openxml4j.opc.PackageRelationship;

import org.apache.xmlbeans.XmlObject;

import java.util.Map;
import java.util.HashMap;

import java.util.regex.Pattern;

import java.lang.reflect.Method;

public class ReadPPTRemoveChart {

 public static void main(String[] args) throws Exception {

  XMLSlideShow slideShow = new XMLSlideShow(new FileInputStream("PPTWithCharts.pptx"));

  XSLFSlide slide = slideShow.getSlides().get(0);

  Map<String, XSLFGraphicFrame> chartFramesToRemove = new HashMap<>();

  for (XSLFShape shape : slide.getShapes()) {
   if (shape instanceof XSLFGraphicFrame) {
    XSLFGraphicFrame graphicframe = (XSLFGraphicFrame)shape;
    XmlObject xmlobject = graphicframe.getXmlObject();
    XmlObject[] graphics = xmlobject.selectPath(
                            "declare namespace a='http://schemas.openxmlformats.org/drawingml/2006/main' " +
                            ".//a:graphic");
    if (graphics.length > 0) { //we have a XSLFGraphicFrame containing a:graphic
     XmlObject graphic = graphics[0];
     XmlObject[] charts = graphic.selectPath(
                           "declare namespace c='http://schemas.openxmlformats.org/drawingml/2006/chart' " +
                           ".//c:chart");
     if (charts.length > 0) { //we have a XSLFGraphicFrame containing c:chart
      XmlObject chart = charts[0];
      String rid = chart.selectAttribute(
                          "http://schemas.openxmlformats.org/officeDocument/2006/relationships", "id")
                          .newCursor().getTextValue();
      chartFramesToRemove.put(rid, graphicframe);
     }
    }
   }
  }

  PackagePart slidepart = slide.getPackagePart();
  OPCPackage opcpackage = slideShow.getPackage();

  for (String rid : chartFramesToRemove.keySet()) {
   //at frist remove the XSLFGraphicFrame
   XSLFGraphicFrame chartFrame = chartFramesToRemove.get(rid);
   slide.removeShape(chartFrame);
   //Here is the problem in my opinion. This **should** remove all related parts too.
   //But since XSLFChart is @Beta, it does not.

   //So we try doing removing the related parts manually.

   //we get the PackagePart of the chart
   PackageRelationship relship = slidepart.getRelationships().getRelationshipByID(rid);
   PackagePart chartpart = slidepart.getRelatedPart(relship);

   //now we get and remove all the relations and related PackageParts from this chartpart
   //this are /ppt/embeddings/Microsoft_Excel_WorksheetN.xlsx, /ppt/charts/colorsN.xml 
   //and /ppt/charts/styleN.xml
   for (PackageRelationship chartrelship : chartpart.getRelationships()) {
    String partname = chartrelship.getTargetURI().toString();
    PackagePart part = opcpackage.getPartsByName(Pattern.compile(partname)).get(0);
    opcpackage.removePart(part);
    chartpart.removeRelationship(chartrelship.getId());
   }

   //now we remove the chart part from the slide part
   //We need doing this on POIXMLDocumentPart level. 
   //Since POIXMLDocumentPart.removeRelation is protected, we need doing this using reflection
   XSLFChart chart = (XSLFChart)slide.getRelationById(rid);
   Method removeRelation = POIXMLDocumentPart.class.getDeclaredMethod("removeRelation", POIXMLDocumentPart.class); 
   removeRelation.setAccessible(true); 
   removeRelation.invoke(slide, chart);

  }

  slideShow.write(new FileOutputStream("PPTWithChartsNew.pptx"));
  slideShow.close();
 }
}