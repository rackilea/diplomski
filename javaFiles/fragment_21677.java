public static void main(String[] args) throws IOException, URISyntaxException{
    getFiles("your/path");

}
public static void getFiles(String path){
    File folder = new File(path);
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        System.out.println("File " + listOfFiles[i].getName());
      } else if (listOfFiles[i].isDirectory()) {
        System.out.println("Directory " + listOfFiles[i].getName());
          getFiles(listOfFiles[i].getPath());
      }
    }
}