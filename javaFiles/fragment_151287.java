Pattern intPattern = Pattern.compile("\\d+");
try(Scanner scanner = new Scanner(Paths.get("foo.txt"));
    BufferedWriter writer = Files.newBufferedWriter(Paths.get("bar.txt"), CREATE_NEW)) {

    String s = scanner.findWithinHorizon(intPattern, 0);
    if(s == null) {
        // perform empty action
    } else {
        // perform pre action
        do {
            writer.append(s);
            writer.newLine();
        } while( (s=scanner.findWithinHorizon(intPattern, 0)) != null);
        // perform post action
    }
}