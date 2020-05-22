public static List<List<String>> parseMessages(Path path) {
    String startPattern = "[MESSAGE BEGIN]";
    String endPattern = "[MESSAGE END]";

    List<List<String>>> result = new ArrayList<>();
    try (BufferedReader buff = Files.newBufferedReader(path)) {
        // Data for current message
        List<String> currentMessage = new ArrayList<>();

        // Read all lines
        while (true) {
            String line = buff.readLine();
            if (line == null) {
                break;
            }

            // Collect current line to message, ignore indicator
            if (!line.equals(endPattern) && !line.equals(startPattern)) {
                currentMessage.add(line);
            }

            // Message ends
            if (line.equals(endPattern)) {
                // Collect message
                result.add(currentMessage);

                // Prepare for next message
                currentMessage = new ArrayList<>();
            }
        }
    }

    return result;
}