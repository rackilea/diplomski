Path child = dir.resolve(name);
    if (kind == StandardWatchEventKinds.ENTRY_CREATE && (check if directory here))
    {
        String destinationToMirror = "D" + child.toString().substring(1);
        File file = new File(destinationToMirror);
        file.mkdir();
    }