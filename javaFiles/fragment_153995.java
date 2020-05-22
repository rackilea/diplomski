XStream instream = new XStream();

BufferedReader br = new BufferedReader(new FileReader("model.xml"));
StringBuffer buff = new StringBuffer();
String line;
while((line = br.readLine()) != null){
   buff.append(line);
}
Platform p = (Platform)instream.fromXML(buff.toString());