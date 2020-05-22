public static void find(String delim) {
    File dir = new File("/tmp/files");
    Pattern strPattern = Pattern.compile(delim);
    if (dir.exists()) {
        try {
            for(File curFile : dir.listFiles()){
              if(!curFile.getName().endsWith(".txt")){continue;}
              BufferedReader in = new BufferedReader(new FileReader(
                       curFile));
              int foundCount = 0;
              String read = null;
              while ((read = in.readLine()) != null) {
                if(strPattern.matcher(read).matches()){
                  foundCount ++;
                }
              }
              System.out.println("Found "+ delim +" "+ foundCount + " time(s) in "+curFile);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("error: dir wasn't found!");
    }
}