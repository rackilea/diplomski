...
 private static void setDataLabelFontSettings(XmlObject series, int number,
  int fontSizePt, boolean b, boolean i, String u, String strike, String typeface, String colorHex) {

  XmlObject[] xmlObjects = series.selectPath(
   "declare namespace cx='http://schemas.microsoft.com/office/drawing/2014/chartex' " +
   ".//cx:dataLabels");
  if (xmlObjects.length == 1) {
   XmlObject dataLabels = xmlObjects[0];
   XmlCursor cursor = dataLabels.newCursor();
   cursor.toLastChild();
   cursor.beginElement(new QName("http://schemas.microsoft.com/office/drawing/2014/chartex", "dataLabel", "cx"));
   cursor.insertAttributeWithValue("idx", "" + number);

   cursor.beginElement(new QName("http://schemas.microsoft.com/office/drawing/2014/chartex", "txPr", "cx"));

   cursor.beginElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "p", "a"));

   cursor.beginElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "r", "a"));

   cursor.beginElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "t", "a"));
   cursor.toParent();
   cursor.setTextValue("dummy");

   cursor.beginElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "rPr", "a"));
   cursor.insertAttributeWithValue("sz", "" + (fontSizePt * 100));
   cursor.insertAttributeWithValue("b", ((b)?"1":"0"));
   cursor.insertAttributeWithValue("i", ((i)?"1":"0"));
   cursor.insertAttributeWithValue("u", u);
   cursor.insertAttributeWithValue("strike", strike);
   cursor.beginElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "latin", "a"));
   cursor.insertAttributeWithValue("typeface", typeface);
   cursor.toParent();
   cursor.beginElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "solidFill", "a"));
   cursor.beginElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "srgbClr", "a"));
   cursor.insertAttributeWithValue("val", colorHex);

   cursor.toParent();
   cursor.toParent();
   cursor.toParent();
   cursor.toParent();
   cursor.toParent();
   cursor.beginElement(new QName("http://schemas.openxmlformats.org/drawingml/2006/main", "bodyPr", "a"));

   cursor.dispose();
  }
 }
...