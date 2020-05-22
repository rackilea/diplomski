import java.io.FileOutputStream;

import org.apache.poi.xslf.usermodel.*;
import org.apache.poi.sl.usermodel.*;

import org.apache.xmlbeans.XmlObject;
import org.openxmlformats.schemas.presentationml.x2006.main.CTShape;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuideList;
import org.openxmlformats.schemas.drawingml.x2006.main.CTGeomGuide;

import java.awt.Rectangle;
import java.awt.Color;

public class CreatePPTXRoundedRectangelShape {

 static void setRadius(XSLFAutoShape autoShape, int percent) {
  if (ShapeType.ROUND_RECT.equals(autoShape.getShapeType())) {
   XmlObject xmlObject = autoShape.getXmlObject();
   CTShape ctShape = (CTShape)xmlObject;
   CTGeomGuideList ctGeomGuideList = ctShape.getSpPr().getPrstGeom().getAvLst();
   CTGeomGuide ctGeomGuide = ctGeomGuideList.addNewGd();
   ctGeomGuide.setName("adj");
   ctGeomGuide.setFmla("val " + (50000*percent/100));
  }
 }

 public static void main(String[] args) throws Exception {

  SlideShow slideShow = new XMLSlideShow();

  Slide slide = slideShow.createSlide();

  int slideWidth = slideShow.getPageSize().width;

  XSLFAutoShape cardRect = ((XSLFSlide)slide).createAutoShape();
  cardRect.setShapeType(ShapeType.ROUND_RECT);
  cardRect.setLineColor(Color.LIGHT_GRAY);
  cardRect.setAnchor(new Rectangle(100, 10, slideWidth-200, 90));
  //default radius

  cardRect = ((XSLFSlide)slide).createAutoShape();
  cardRect.setShapeType(ShapeType.ROUND_RECT);
  cardRect.setLineColor(Color.LIGHT_GRAY);
  cardRect.setAnchor(new Rectangle(100, 110, slideWidth-200, 90));
  setRadius(cardRect, 0); //0 radius

  cardRect = ((XSLFSlide)slide).createAutoShape();
  cardRect.setShapeType(ShapeType.ROUND_RECT);
  cardRect.setLineColor(Color.LIGHT_GRAY);
  cardRect.setAnchor(new Rectangle(100, 210, slideWidth-200, 90));
  setRadius(cardRect, 50); //50% radius

  cardRect = ((XSLFSlide)slide).createAutoShape();
  cardRect.setShapeType(ShapeType.ROUND_RECT);
  cardRect.setLineColor(Color.LIGHT_GRAY);
  cardRect.setAnchor(new Rectangle(100, 310, slideWidth-200, 90));
  setRadius(cardRect, 100); //100% radius

  cardRect = ((XSLFSlide)slide).createAutoShape();
  cardRect.setShapeType(ShapeType.ROUND_RECT);
  cardRect.setLineColor(Color.LIGHT_GRAY);
  cardRect.setAnchor(new Rectangle(100, 410, slideWidth-200, 90));
  setRadius(cardRect, 33); //33% radius

  FileOutputStream out = new FileOutputStream("CreatePPTXRoundedRectangelShape.pptx");
  slideShow.write(out);
  out.close();
 }
}