@Override
public int getChildCount(Object parent) {
    if (parent instanceof java.io.File && ((java.io.File) parent).canRead()) {
        List<File> files = children(parent);
        int result = 0;
        for (java.io.File file : files) {
            if (((file.isDirectory() && onlyFolders) || !onlyFolders)
                    && ((!file.isHidden() && !showHidden) || showHidden)) {
                result++;
            }
        }
        return result;
    }
    return 0;
}

@Override
public Object getChild(Object parent, int index) {
    if (parent instanceof java.io.File) {
        List<File> files = children(parent);
        List<java.io.File> resultFiles = new LinkedList<>();
        for (java.io.File file : files) {
            if (((file.isDirectory() && onlyFolders) || !onlyFolders)
                    && ((!file.isHidden() && !showHidden) || showHidden)) {
                resultFiles.add(file);
            }
        }
        return resultFiles.get(index);
    }
    return null;
}