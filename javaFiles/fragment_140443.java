ArrayList<String> filePaths = new ArrayList<String>();
        File rootFolder = new File("F:\\java");
        String targetFile = "sample.txt";
        filePaths = searchForFile(rootFolder, filePaths, targetFile);
        if(filePaths==null)
            System.out.println("No file is found");
        else
        {
            for (String string : filePaths)
            {
                System.out.println(string);
            }
        }