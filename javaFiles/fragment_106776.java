public final class CaseSensitiveNTFSFileSystem
    extends FileSystem
{
    private static final Pattern MYSYNTAX = Pattern.compile("glob:\\*(\\..*)");

    private final FileSystem fs;

    // "fs" is the "genuine" FileSystem provided by the JVM
    public CaseSensitiveNTFSFileSystem(final FileSystem fs)
    {
        this.fs = fs;
    }

    @Override
    public PathMatcher getPathMatcher(final String syntaxAndPattern)
    {
        final Matcher matcher = MYSYNTAX.matcher(syntaxAndPattern);
        if (!matcher.matches())
            throw new UnsupportedOperationException();
        final String suffix = matcher.group(1);
        final PathMatcher orig = fs.getPathMatcher(syntaxAndPattern);

        return new PathMatcher()
        {
            @Override
            public boolean matches(final Path path)
            {
                return orig.matches(path)
                    && path.getFileName().endsWith(suffix);
            }
        };
    }

    // Delegate all other methods of FileSystem to "fs"
}