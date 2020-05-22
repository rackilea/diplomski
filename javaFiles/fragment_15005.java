// only needed once for all files
Pattern pattern = Pattern.compile("(.+?)(\\.war)$");

// collect all files in all relevant directories
List<File> potentialFiles = new ArrayList<>();
potentialFiles.addAll(Arrays.asList(new File("./target/").listFiles()));
potentialFiles.addAll(Arrays.asList(new File("./nameOfComponent/target/").listFiles()));

File webapp = null;
for (File file : potentialFiles) {
    Matcher matcher = pattern.matcher(file.getName());
    if (matcher.matches()) {
        webapp = file;
        break; // use this line if you only want the first match
    }
}

// use "webapp", but expect null if there was no match