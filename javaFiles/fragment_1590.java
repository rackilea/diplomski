public static void printFileNamesRecursively(String path){
    Path yourPath = FileSystems.getDefault().getPath(path);

    try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(yourPath))           {  
            for (Path p : directoryStream) {
                System.out.println(p.getFileName());
                if(p.toFile().isDirectory()){

                    printFileNamesRecursively(p.toString());
                }

            }
        } catch (IOException e) {  
            e.printStackTrace();  
        }
}