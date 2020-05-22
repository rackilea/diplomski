URL urlOutput = new URL("ftp://username:password@ftp.matsworld.io");
URLConnection urlc = urlOutput.openConnection();
OutputStream os = urlc.getOutputStream();
OutputStream buffer = new BufferedOutputStream(os);
PrintStream output = new PrintStream(buffer);
output.writeLine("Hello world!");
output.close();
buffer.close();
os.close();