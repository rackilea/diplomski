BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new
  FileOutputStream(FileDescriptor.out), "ASCII"), 512);
out.write("test");
out.flush();
out.write(" > ");
out.flush();
out.write("string");
out.flush();