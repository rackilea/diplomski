File f = new File("path-to-your-file");
DataInputStream dis = new DataInputStream(new FileInputStream(f)); //to read the file
byte[] b = new byte[(int)f.length()]; //to store the bytes
int l = dis.read(b); //stores the bytes in b
dis.close();
DataOutputStream dos = new DataOutputStream(new FileOutputStream(new File("new-file"))); // to write the file
dos.write(b,0,l); //writes the bytes from b to the file
dos.close();