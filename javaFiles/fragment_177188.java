public WildcardFileFilter implements LocalFileFilter {
    private String wildcardPattern;

    public WildcardFileFilter(String wildcardPattern) {
        this.wildcardPattern = wildcardPattern;
    }

    @Override
    public boolean accept(LocalSourceFile file) {
        return FilenameUtils.wildcardMatchOnSystem(file.getName(), wildcardPattern);
    }
}