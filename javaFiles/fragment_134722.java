URL  url = new URL("ftp://username:pass@thunder.cise.ufl.edu/public/foler/a.txt;type=i");
URLConnection urlc = url.openConnection();
OutputStream os = urlc.getOutputStream(); // To upload
OutputStream buffer = new BufferedOutputStream(os);
PrintStream output = new PrintStream(buffer);
output.print("hello");

buffer.close();
os.close();
output.close();