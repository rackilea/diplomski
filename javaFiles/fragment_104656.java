/**
 * Get a file relative to the application root path.
 *
 * @param relativePath relative path of the file to fetch
 * @return a file instance - it is not guaranteed that the file exists
 */
default File getFile(String relativePath) {
    return getWrappedApplication().getFile(relativePath);
}