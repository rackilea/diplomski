StringBuilder sb = new StringBuilder();
sb.append("Test String");

File f = new File("d:\\test.zip");
ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
ZipEntry e = new ZipEntry("mytext.txt");
out.putNextEntry(e);

byte[] data = sb.toString().getBytes();
out.write(data, 0, data.length);
out.closeEntry();

out.close();