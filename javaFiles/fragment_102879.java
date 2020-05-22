BufferedReader reader = new BufferedReader(new FileReader(file));
StringBuilder cerfile = new StringBuilder();
String line = null;
while(( line = reader.readLine())!=null){
  if(!line.contains("PKCS7")){
    cerfile.append(line);
  }
}
byte[] fileBytes = Base64.decode(cerfile.toString().getBytes());