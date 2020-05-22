private static class WildcardFilenameFilter implements SmbFilenameFilter {
    private static final String DEFAULT_WIDLCARD = "*";

    private final String wildcard = DEFAULT_WIDLCARD;
    private final String regex;

    public WildcardFilenameFilter(String filename) {
        regex = createRegexPattern(filename);
    }

    @Override
    public boolean accept(SmbFile dir, String name) throws SmbException {
        return name.matches(regex);
    }

    private String createRegexPattern(String filename) {
        return filename.replace(".", "\\.").replace(wildcard, ".+");
    }
}