try(BufferedReader in = new BufferedReader(new FileReader(file_live);
   BufferedWriter out = new BufferedWriter(new FileWriter(file_live+".tmp"))) {
   // skip the first line
   in.readLine();
   char[] buffer = new char[8*1024];
   for(int len; (len = in.read(buffer)) > 0;)
       out.write(buffer, 0, len);
}
new File(file_live).delete();
new File(file_live+".tmp").renameTo(new File(file_live));