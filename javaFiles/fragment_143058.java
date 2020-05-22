PdfReader reader = new PdfReader("D://testPdf.pdf");
PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("D://stamperPdf.pdf"));
AcroFields form = stamper.getAcroFields();

// get Image and rotate it
Image img = Image.getInstance("D://testImg.png");
img.setRotationDegrees(90);
img.setAbsolutePosition(0, 0);

// create template with scaled width and height
PdfTemplate tp = PdfTemplate.createTemplate(stamper.getWriter(), img.getScaledWidth(),
                                            img.getScaledHeight());
tp.addImage(img);


PushbuttonField field = form.getNewPushbuttonFromField("Field");
field.setLayout(PushbuttonField.LAYOUT_ICON_ONLY);
field.setProportionalIcon(true);
field.setTemplate(tp);  // set template with image to field
form.replacePushbuttonField("Field", field.getField());