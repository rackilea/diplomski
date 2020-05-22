public static void main(String[] args) {

    String WILD_CARD = "";
     List<File> fileList = new LinkedList<File>();
       File folder = new File("d:\\");
       File[] listOfFiles = folder.listFiles();
        if(WILD_CARD!=null) {  
            Pattern wildCardPattern = Pattern.compile(".*"+WILD_CARD+"(.*)?.mpp",Pattern.CASE_INSENSITIVE);
            for(File file: listOfFiles) {
                Matcher match = wildCardPattern.matcher(file.getName());
                while(match.find()){
                    String fileMatch = match.group();
                    if(file.getName().equals(fileMatch))  {
                        fileList.add(file); // doesn't work
                    }
                }
            }
        }
        else
            fileList = new LinkedList<File>( Arrays.asList(folder.listFiles()));

        for (File f: fileList) System.out.println(f.getName());
}