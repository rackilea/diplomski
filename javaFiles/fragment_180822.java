ProcessBuilder pb = new ProcessBuilder("prog.exe");
Process p = pb.start();
OutputStream pos = p.getOutputStream();

InputStream fis = new FileInputStream("file.txt");
byte[] buffer = new byte[1024];
int read = 0;
while((read = fis.read(buffer)) != -1) {
    pos.write(buffer, 0, read);
}
fis.close();