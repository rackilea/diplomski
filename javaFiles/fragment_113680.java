/**
     * Tests whether a file exists.
     *
     * <p> The {@code options} parameter may be used to indicate how symbolic links
     * are handled for the case that the file is a symbolic link. By default,
     * symbolic links are followed. If the option {@link LinkOption#NOFOLLOW_LINKS
     * NOFOLLOW_LINKS} is present then symbolic links are not followed.
     *
     * <p> Note that the result of this method is immediately outdated. If this
     * method indicates the file exists then there is no guarantee that a
     * subsequence access will succeed. Care should be taken when using this
     * method in security sensitive applications.
     *
     * @param   path
     *          the path to the file to test
     * @param   options
     *          options indicating how symbolic links are handled
     * .
     * @return  {@code true} if the file exists; {@code false} if the file does
     *          not exist or its existence cannot be determined.
     *
     * @throws  SecurityException
     *          In the case of the default provider, the {@link
     *          SecurityManager#checkRead(String)} is invoked to check
     *          read access to the file.
     *
     * @see #notExists
 */
public static boolean exists(Path path, LinkOption... options) {
    try {
        if (followLinks(options)) {
            provider(path).checkAccess(path);
        } else {
            // attempt to read attributes without following links
            readAttributes(path, BasicFileAttributes.class,
                           LinkOption.NOFOLLOW_LINKS);
        }
        // file exists
        return true;
    } catch (IOException x) {
        // does not exist or unable to determine if file exists
        return false;
    }

}