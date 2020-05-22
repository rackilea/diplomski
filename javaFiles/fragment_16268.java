import java.io.FileOutputStream;

import org.apache.poi.xslf.usermodel.*;
import org.apache.poi.sl.usermodel.*;

import java.awt.Rectangle;
import java.awt.geom.Path2D;
import java.awt.geom.PathIterator;
import java.awt.geom.AffineTransform;

public class CreatePPTXFreeformShape {

 static String getPathString(Path2D.Double path2D) {
  double[] coords = new double[6];
  StringBuilder pathStringBuilder = new StringBuilder();
  for (PathIterator pathIterator = path2D.getPathIterator(new AffineTransform()); !pathIterator.isDone(); pathIterator.next()) {
   int type = pathIterator.currentSegment(coords);
   if (type == PathIterator.SEG_MOVETO) {
    pathStringBuilder.append("M");
    pathStringBuilder.append(coords[0] + "," + coords[1]);
    pathStringBuilder.append(" ");
   } else if (type == PathIterator.SEG_LINETO) {
    pathStringBuilder.append("L");
    pathStringBuilder.append(coords[0] + "," + coords[1]);
    pathStringBuilder.append(" ");
   } else if (type == PathIterator.SEG_QUADTO) {
    pathStringBuilder.append("Q");
    pathStringBuilder.append(coords[0] + "," + coords[1] + "," + coords[2] + "," + coords[3]);
    pathStringBuilder.append(" ");
   } else if (type == PathIterator.SEG_CUBICTO) {
    pathStringBuilder.append("C");
    pathStringBuilder.append(coords[0] + "," + coords[1] + "," + coords[2]+ "," + coords[3] + "," + coords[4] + "," + coords[5]);
    pathStringBuilder.append(" ");
   } else if (type == PathIterator.SEG_CLOSE) {
    pathStringBuilder.append("Z");
    pathStringBuilder.append(" ");
   }
  }
  return pathStringBuilder.toString();
 }

 public static void main(String[] args) throws Exception {

  XMLSlideShow slideShow = new XMLSlideShow();
  XSLFSlide slide = slideShow.createSlide();

  Path2D.Double path2D = null;

  XSLFFreeformShape shape1 = slide.createFreeform();

  path2D = new Path2D.Double();
  path2D.moveTo(100.000,100.000);
  path2D.lineTo(-0.000,100.000);
  path2D.lineTo(-0.000,-0.000);
  path2D.lineTo(100.000,-0.000);
  //path2D.lineTo(100.000,100.000);
  path2D.closePath();

  shape1.setPath(path2D);

  shape1.setLineWidth(1.0);
  shape1.setLineColor(java.awt.Color.BLACK);
  shape1.setAnchor(new Rectangle(100, 100, 100, 100));

  XSLFFreeformShape shape2 = slide.createFreeform();
  path2D = new Path2D.Double();
  path2D.moveTo(100.000,100.000);
  path2D.curveTo(60.000,0.000, 40.000,0.000, 0.000,100.000);
  path2D.closePath();

  shape2.setPath(path2D);

  shape2.setLineWidth(1.0);
  shape2.setLineColor(java.awt.Color.BLACK);
  shape2.setAnchor(new Rectangle(300, 100, 100, 100));

  XSLFFreeformShape shape3 = slide.createFreeform();
  path2D = new Path2D.Double();
  path2D.moveTo(100.000,100.000);
  path2D.quadTo(50.000,0.000, 0.000,100.000);
  path2D.closePath();

  shape3.setPath(path2D);

  shape3.setLineWidth(1.0);
  shape3.setLineColor(java.awt.Color.BLACK);
  shape3.setAnchor(new Rectangle(500, 100, 100, 100));

  String pathString = getPathString(shape1.getPath());
  System.out.println(pathString);

  pathString = getPathString(shape2.getPath());
  System.out.println(pathString);

  pathString = getPathString(shape3.getPath());
  System.out.println(pathString);

  FileOutputStream out = new FileOutputStream("CreatePPTXFreeformShape.pptx");
  slideShow.write(out);
  out.close();
 }
}