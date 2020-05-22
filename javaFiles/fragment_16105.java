Map<Path, List<String>> readFiles = new TreeMap<>(new Comparator<Path>() {
    @Override
    public int compare(Path o1, Path o2) {
        Matcher o1Matcher = NUMBER_PATTERN.matcher(o1.getFileName().toString());
        Matcher o2Matcher = NUMBER_PATTERN.matcher(o2.getFileName().toString());
        if (o1Matcher.find() && o2Matcher.find()) {
            return Integer.compare(Integer.parseInt(o1Matcher.group()), Integer.parseInt(o2Matcher.group()));
        } else {
            return o1.compareTo(o2);
        }
    }
});