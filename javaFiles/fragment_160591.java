public void recursivelySearchFiles(String startPath) throws IOException {

     File root = new File(startPath);
     File[] list = root.listFiles();

     if (list == null) return;

     for ( File f : list ) {
         if ( f.isDirectory() ) {
             recursivelySearchFiles(f.getAbsolutePath());
         }
         else {
             BufferedReader br = new BufferedReader(new FileReader(f));
             String resultYear = "";
             String line;
             while ((line = br.readLine()) != null) {
             resultYear = getSubStringFromString(line);

             }
             br.close();
             renameFile(f, resultYear);
             System.out.println( "File:" + f.getAbsoluteFile() );
         }
     }
 }

 public String getSubStringFromString(String line){
     Pattern pattern = Pattern.compile("\\d{4}");
     Matcher matcher = pattern.matcher(line);
     if (matcher.find())
     {
         return matcher.group(1);
     }else{
         return "";
     }
 }

 public void renameFile(File oldfile, String year) throws IOException{
        String newPath = oldfile.getAbsolutePath().substring(0, oldfile.getAbsolutePath().lastIndexOf("."));
        String ending = oldfile.getAbsolutePath().substring(oldfile.getAbsolutePath().lastIndexOf(".")-1, oldfile.getAbsolutePath().length());
        newPath += year;
        File file2 = new File(newPath + ending);
        if(file2.exists()) throw new java.io.IOException("file exists");

        boolean success = oldfile.renameTo(file2);
        if (!success) {
            System.out.println("renaming not successful");
        }
 }