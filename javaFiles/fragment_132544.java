File file = new File("music.wav");
byte[] data = new byte[file.length()];
FileInputStream in = new FileInputStream(file);
in.read(data);
in.close();

//encrypt data

FileOutputStream out = new FileOutputStream(file);
out.write(data);
out.close();