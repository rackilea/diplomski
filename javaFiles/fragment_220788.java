InputStream input = null;
OutputStream output = null;

File folder = new File("/sdcard", "hellofolder");
folder.mkdirs();

File myFile = new File("/sdcard/hellofolder/hello.pdf");
output = new FileOutputStream(myFile);