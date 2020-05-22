Scanner testscn = new Scanner(input).useDelimiter("\n");
testscn.forEachRemaining((scan) -> {
    String[] line = scan.split("-");

    File img = new File(line[0]);
    if (img.exists()) {
        test.put(img, line[1].split(","));
    } else {
        logger.warn("File path " + line[0] + ": Skipping.");
    }
});
testscn.close();