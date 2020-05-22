File file = ...;
long pos = 0;
long size = file.length();
FileInputStream fis = new FileInputStream(file);
FileChannel fc = fis.getChannel();
MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_ONLY, pos, size);
BufferedReader br = new BufferedReader(new InputStreamReader(fis));