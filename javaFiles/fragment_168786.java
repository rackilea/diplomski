File dir = new File(".");

String[] names = dir.list(
    new FilenameFilter()
    {
        public boolean accept(File dir, String name)
        {
            return name.endsWith(".message");
        }
    });