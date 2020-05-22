public static File createTempFile(String prefix, String suffix,
                                  File directory)
    throws IOException
{
    if (prefix.length() < 3)
        throw new IllegalArgumentException("Prefix string too short");
    if (suffix == null)
        suffix = ".tmp";

    File tmpdir = (directory != null) ? directory
                                      : TempDirectory.location();
    SecurityManager sm = System.getSecurityManager();
    File f;
    do {
        f = TempDirectory.generateFile(prefix, suffix, tmpdir);

        if (sm != null) {
            try {
                sm.checkWrite(f.getPath());
            } catch (SecurityException se) {
                // don't reveal temporary directory location
                if (directory == null)
                    throw new SecurityException("Unable to create temporary file");
                throw se;
            }
        }
    } while ((fs.getBooleanAttributes(f) & FileSystem.BA_EXISTS) != 0);

    if (!fs.createFileExclusively(f.getPath()))
        throw new IOException("Unable to create temporary file");

    return f;
}