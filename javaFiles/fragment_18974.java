FileOutputStream os = new FileOutputStream("someFile.xml");
XMLEncoder encoder = new XMLEncoder(os);
MyObject p = new MyObject();
p.setFirstName("Mite");
encoder.writeObject(p);
encoder.close();