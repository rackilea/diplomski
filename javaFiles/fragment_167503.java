private void openDirectory(File f, String path) {
        if (path==null) return;
        if (!(path.endsWith(File.separator)||path.endsWith("/")))
            path += File.separator;
        String[] names = f.list();
        names = (new FolderOpener()).trimFileList(names);
        if (names==null)
            return;
        convertToRGB = false;
        virtualStack = false;
        String options  = " sort";
        if (convertToRGB) options += " convert_to_rgb";
        if (virtualStack) options += " use";
        IJ.run("Image Sequence...", "open=[" + path + "]"+options);
        DirectoryChooser.setDefaultDirectory(path);
        IJ.register(DragAndDrop.class);
    }