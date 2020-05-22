InputStream in = G1G2Launcher.class.getClass().getResourceAsStream("file.xls")
OutputStream out = new FileOutputStream(new File("file.xls"));
int read = 0;
byte[] bytes = new byte[1024];
while ((read = in.read(bytes)) != -1) {
    out.write(bytes, 0, read);
}