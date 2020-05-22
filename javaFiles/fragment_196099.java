String toSplit ="FN:Your Name";
Pattern pattern = Pattern.compile("(?:FN:)([A-Za-z]*) ([A-Za-z]*)");
Matcher matcher = pattern.matcher(toSplit);
if (matcher.find()) {
    String[] splitted = new String[]{
        matcher.group(1),
        matcher.group(2)
    };
    System.out.println("splitted: " + Arrays.toString(splitted));
}