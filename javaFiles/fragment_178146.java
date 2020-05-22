FileInputStream fis = new FileInputStream(myFile);
BufferedReader stream = new BufferedReader(new InputStreamReader(fis, "ISO-8859-1"));
String line;
while ((line = stream.readLine()) != null) {
     //save your lines to an array or list       
}
stream.close();
fis.close();