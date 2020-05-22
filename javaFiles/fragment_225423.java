public static class ComputerNodeFriendlyFileSystemView extends FileSystemView {

    private final FileSystemView delegate;

    public ComputerNodeFriendlyFileSystemView(FileSystemView delegate) {
        this.delegate = delegate;
    }

    @Override
    public File createFileObject(String path) {
        File placeholderFile = new File(path);
        if (ShellFolder.isComputerNode(placeholderFile)) {
            try {
                return getComputerNodeFolder(path);
            } catch (FileNotFoundException ex) {
                return placeholderFile;
            }
        } else {
            return delegate.createFileObject(path);
        }
    }

    // All code below simply delegates everything to the "delegate"

    @Override
    public File createNewFolder(File containingDir) throws IOException {
        return delegate.createNewFolder(containingDir);
    }

    @Override
    public boolean isRoot(File f) {
        return delegate.isRoot(f);
    }

    @Override
    public Boolean isTraversable(File f) {
        return delegate.isTraversable(f);
    }

    @Override
    public String getSystemDisplayName(File f) {
        return delegate.getSystemDisplayName(f);
    }

    @Override
    public String getSystemTypeDescription(File f) {
        return delegate.getSystemTypeDescription(f);
    }

    @Override
    public Icon getSystemIcon(File f) {
        return delegate.getSystemIcon(f);
    }

    @Override
    public boolean isParent(File folder, File file) {
        return delegate.isParent(folder, file);
    }

    @Override
    public File getChild(File parent, String fileName) {
        return delegate.getChild(parent, fileName);
    }

    @Override
    public boolean isFileSystem(File f) {
        return delegate.isFileSystem(f);
    }

    @Override
    public boolean isHiddenFile(File f) {
        return delegate.isHiddenFile(f);
    }

    @Override
    public boolean isFileSystemRoot(File dir) {
        return delegate.isFileSystemRoot(dir);
    }

    @Override
    public boolean isDrive(File dir) {
        return delegate.isDrive(dir);
    }

    @Override
    public boolean isFloppyDrive(File dir) {
        return delegate.isFloppyDrive(dir);
    }

    @Override
    public boolean isComputerNode(File dir) {
        return delegate.isComputerNode(dir);
    }

    @Override
    public File[] getRoots() {
        return delegate.getRoots();
    }

    @Override
    public File getHomeDirectory() {
        return delegate.getHomeDirectory();
    }

    @Override
    public File getDefaultDirectory() {
        return delegate.getDefaultDirectory();
    }

    @Override
    public File createFileObject(File dir, String filename) {
        return delegate.createFileObject(dir, filename);
    }

    @Override
    public File[] getFiles(File dir, boolean useFileHiding) {
        return delegate.getFiles(dir, useFileHiding);
    }

    @Override
    public File getParentDirectory(File dir) {
        return delegate.getParentDirectory(dir);
    }
}