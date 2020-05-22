byte[] immAsBytes = 
ByteArrayOutputStream baos = new ByteArrayOutputStream();
//use another encoding if JPG is innappropriate for you
ImageIO.write(imm, "jpg", baos );
baos.flush();
byte[] immAsBytes = baos.toByteArray();
baos.close();