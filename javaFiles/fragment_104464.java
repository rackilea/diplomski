InputStream is1 = con1.getInputStream();
BufferedInputStream bis = new BufferedInputStream(is1);
byte[] buffer = new byte[2048]; // or whatever size you want
int n;
OutputStream os = new FileOutputStream("test.doc");
while ((n = bis.read(buffer)) >= 0) {
    os.write(buffer, 0, n);
}
os.close();
bis.close();