Process proc = Runtime.getRuntime().exec(cmd);
InputStream in = proc.setOutputStream();
OutputStream out = new FileOutputStream("johnsmith.cert.csr");
int b;
while( (b = in.read()) != -1) {
   out.write(b);
}
out.flush();
out.close();