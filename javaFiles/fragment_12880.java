public static void main(String[] args) {
    final String INPUT = "{\"locations\":["
            + "{\"latitude\":\"1.3846519\",\"longitude\":\"103.763276\",\"startTime\":\"1422720220292\",\"duration\":\"0\",\"accuracy\":\"50.981998443604\"},"
            + "{\"latitude\":\"1.3845814\",\"longitude\":\"103.7634384\",\"startTime\":\"1422720520181\",\"duration\":\"0\",\"accuracy\":\"55.532001495361\"},"
            + "{\"latitude\":\"1.3844195\",\"longitude\":\"103.763209\",\"startTime\":\"1422720820265\",\"duration\":\"0\",\"accuracy\":\"34.5\"},"
            + "{\"latitude\":\"1.3844051\",\"longitude\":\"103.7632272\",\"startTime\":\"1422721120466\",\"duration\":\"0\",\"accuracy\":\"36\"},"
            + " ],\"success\":1}";
    String latitudeArray[] = splitAndCollect("latitude", INPUT);
    String longitudeArray[] = splitAndCollect("longitude", INPUT);
    String startTimeArray[] = splitAndCollect("startTime", INPUT);
    String durationArray[] = splitAndCollect("duration", INPUT);
    String accuracyArray[] = splitAndCollect("accuracy", INPUT);
    System.out.println("Done");
}

private static String[] splitAndCollect(String string, String input) {
    final String COLON = "\":\"";
    String[] split = input.split(string + COLON);
    String[] output = new String[split.length - 1];
    for (int i = 0; i < output.length; i++)
        // Using [i+1] - since split[0] contains "locations".
        // Subsequent splits will have the numbers needed.
        output[i] = split[i + 1].substring(0, split[i + 1].indexOf("\""));
    System.out.println(string + "\n" + Arrays.toString(output));
    return output;
}