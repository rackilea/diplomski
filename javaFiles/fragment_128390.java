// save to file
// =======================================
InputStream is = new BufferedInputStream(item.openStream());
BufferedOutputStream output = null;

try {
    output = new BufferedOutputStream(new FileOutputStream("temp.txt", false));
    int data = -1;
    while ((data = is.read()) != -1) {
        output.write(data);
    }
} finally {
    is.close();
    output.close();
}

// read content of file
// =======================================
System.out.println("content of file:");
try {
    FileInputStream fstream = new FileInputStream("temp.txt");

    DataInputStream in = new DataInputStream(fstream);
    BufferedReader br = new BufferedReader(new InputStreamReader(in));
    String line;

    licenseString = "";
    String strLine;
    while ((strLine = br.readLine()) != null)   {
          System.out.println(javax.xml.bind.DatatypeConverter.printBase64Binary(strLine.getBytes()));
          licenseString += javax.xml.bind.DatatypeConverter.printBase64Binary(strLine.getBytes()) + "\n";
    }                                           
} catch (Exception e) {
    System.err.println("Error: " + e.getMessage());
}