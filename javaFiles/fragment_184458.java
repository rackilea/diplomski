//image == string containing path to my .png image file
Image img = Image.getInstance(image);
img.scaleAbsolute(200,200);
img.setBorder(Rectangle.BOX);
img.setBorderColor(BaseColor.RED);
img.setBorderWidth(1f);

doc.add(img);