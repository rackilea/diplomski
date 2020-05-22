File file = new File("C://fichero.csv");

BufferedReader bufRdr  = new BufferedReader(
    new InputStreamReader(new FileInputStream(file),"ISO-8859-1"));
String line = null;

line = bufRdr.readLine();