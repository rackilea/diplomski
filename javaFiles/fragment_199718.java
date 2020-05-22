InputStream is = Main.class.getResourceAsStream("raw/"+lst);
BufferedInputStream bs = new BufferedInputStream(is);
byte buffer[] = new byte[is.available()];
bs.read(buffer);
is.close();
bs.close();
FileOutputStream fos = new FileOutputStream("Lists/"+lst);
fos.write(buffer);
fos.close();