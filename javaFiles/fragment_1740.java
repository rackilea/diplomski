//Read file content
FileInputStream in = new FileInputStream(new File("absolute path"));
byte[] bt = new byte[(int) file.length()];
in.read(bt);
in.close();
return bt;