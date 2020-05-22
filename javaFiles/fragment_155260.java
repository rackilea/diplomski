FileInputStream fis = null;

File image = new File("\\yourpath\test.PNG");
fis = new FileInputStream(image);
prepare.setBinaryStream(2,fis,(int)image.length());
prepare.execute();