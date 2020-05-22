FileWriter writer;
try {
writer = new FileWriter(new File("myVirtual.xml"));
writer.write(mySuites.toXml());
writer.flush();
writer.close();
System.out.println(new File("myVirtual.xml").getAbsolutePath());
} catch (IOException e) {

e.printStackTrace();
}