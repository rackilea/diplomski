public long getMinutes(String input) {
    input = input.toLowerCase()
                 .replaceAll("mins?", "M") 
                 .replaceAll("hrs?", "H")
                 .replaceAll("\\s+", "");
    Duration d = Duration.parse("PT" + input);
    return d.toMinutes();
}