public static String[] GetFiles(final String path, final String searchPattern) {
    final Pattern re = Pattern.compile(searchPattern.replace("*", ".*").replace("?", ".?"));
    return new File(path).list(new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
            return new File(dir, name).isFile() && re.matcher(name).matches();
        }
    });
}