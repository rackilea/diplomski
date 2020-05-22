public void getPathFilesystem(String path)
    {
        try
        {
            URI rootURI = new URI("file:///");
            Path rootPath = Paths.get(rootURI);
            Path dirPath = rootPath.resolve(path);
            FileStore dirFileStore = Files.getFileStore(dirPath);

            printFileStore(dirFileStore, path);
        }
        catch (IOException | URISyntaxException e)
        {
            e.printStackTrace();
        }
    }

    public void printFileStore(FileStore filestore, String path)
    {
        try
        {
            System.out.println("Name: " + filestore.name());
            System.out.println("\tPath: " + path);
            System.out.println("\tSize: " + filestore.getTotalSpace());
            System.out.println("\tUnallocated: " + filestore.getUnallocatedSpace());
            System.out.println("\tUsable: " + filestore.getUsableSpace());
            System.out.println("\tType: " + filestore.type());
        }
        catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }