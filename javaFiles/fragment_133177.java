String totalString = "/mnt/sdcard/PDF/abc.pdf";
File f = new File(totalString);
String filename = f.getName();
String filePath = f.getParent();
System.out.println(filename);
System.out.println(filePath);