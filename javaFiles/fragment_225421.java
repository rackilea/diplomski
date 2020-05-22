/**
 * Create a shell folder for a given network path.
 *
 * @param path File to test for existence.
 * @return ShellFolder representing the given computer node.
 * @throws IllegalArgumentException given path is not a computer node.
 * @throws FileNotFoundException given path could not be found.
 */
public static ShellFolder getComputerNodeFolder(String path)
        throws FileNotFoundException {
    File file = new NonCanonicalizingFile(path);
    if (ShellFolder.isComputerNode(file)) {
        return new Win32ShellFolderManager2().createShellFolder(file);
    } else {
        throw new IllegalArgumentException("Given path is not a computer node.");
    }
}

private static final class NonCanonicalizingFile extends File {
    public NonCanonicalizingFile(String path) {
        super(path);
    }

    @Override
    public String getCanonicalPath() throws IOException {
        // Win32ShellFolderManager2.createShellFolder() will call getCanonicalPath() on this file.
        // Base implementation of getCanonicalPath() calls WinNTFileSystem.canonicalize() which fails on
        // computer nodes (e.g. "\\blah"). We skip the canonicalize call, which is safe at this point because we've
        // confirmed (in approveSelection()) that this file represents a computer node.
        return getAbsolutePath();
    }
}