public static String compressString(String str) throws IOException{
if (str == null || str.length() == 0) {
    return str;
}

BufferedWriter writer = null;

try{
    File file =  new File("your.gzip")
    GZIPOutputStream zip = new GZIPOutputStream(new FileOutputStream(file));

    writer = new BufferedWriter(new OutputStreamWriter(zip, "UTF-8"));

    writer.append(str);
}
finally{           
    if(writer != null){
     writer.close();
     }
  }
 }