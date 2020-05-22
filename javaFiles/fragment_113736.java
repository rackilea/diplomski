File       prefix    = new File(path);
File       directory = prefix.getParentFile();
List<File> matches   = directory.listFiles((dir, name) ->
                           name.startsWith(prefix.getName() + "."));

for (File match: matches) {
    System.out.printf("Found %s%n", match);
}