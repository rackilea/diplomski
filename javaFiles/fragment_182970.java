File imageFile;
DataInputStream dis = new DataInputStream(new FileInputStream(imageFile));

int input = dis.read();

dis.close();