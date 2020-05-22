Tesseract instance = new Tesseract();
instance.setDatapath(".");
String result = instance.doOCR(imageFile);
String fileName = imageFile.getName().replace(".jpg", "");
System.out.println("Parsed Image " + fileName);
return result;