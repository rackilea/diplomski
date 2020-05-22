JarFile myEAR = new JarFile(urlOfMyEAR);

File f = File.createTempFile("jar", null);
FileOutputStream resourceOS = new FileOutputStream(f);
byte[] byteArray = new byte[1024];
int i;

InputStream jarIS = myEAR.getInputStream(myEAR.getEntry(libname));
while ((i = jarIS.read(byteArray)) > 0) {
    //Write the bytes to the output stream
    resourceOS.write(byteArray, 0, i);
}
//Close streams to prevent errors
jarIS.close();
resourceOS.close();

JarFile myJAR = new JarFile(f);

Attributes m = myJAR.getManifest().getMainAttributes();

System.out.println(m.getValue("Implementation-Version"));