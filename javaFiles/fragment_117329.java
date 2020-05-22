Queue<File> queue = new LinkedList<File>();
    queue.add(parent);

    ArrayList<File> mediaFiles = new ArrayList<File>();

    while (!queue.isEmpty()) {
        File file = queue.remove();

        if (file.isDirectory())
        {
            ArrayList<File> subFolders = new ArrayList<File>(
                    Arrays.asList(file
                            .listFiles(filter)));
            for (File sub : subFolders) {
                queue.add(sub);
            }
        }
        else
        {
            mediaFiles.add(file);
        }

    }