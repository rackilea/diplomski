File source = new File("C:\\Users\\rr\\test\\XYZ.docx");

SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH-mm-ss");
String ts = sdf.format(source.lastModified());
String name = source.getName();
String ext = name.substring(name.lastIndexOf("."));
name = name.substring(0, name.lastIndexOf("."));
String outFileName = name + " " + ts + ext;
//appending ts to the file name
System.out.println(" new file name is " + outFileName);

File destination = new File("C:\\Users\\rr", outFileName);