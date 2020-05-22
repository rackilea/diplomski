String needle = "uan:123";

String startPattern = "[MESSAGE BEGIN]";
String endPattern = "[MESSAGE END]";

List<List<String>>> result = new ArrayList<>();
try (BufferedReader buff = Files.newBufferedReader(getPath())) {
    // Lines and flag for current message
    List<String> currentMessage = new ArrayList<>();
    boolean messageContainedNeedle = false;

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

        // Set flag if message contains needle
        if (!messageContainedNeedle && line.equals(needle)) {
            messageContainedNeedle = true;
        }

        // Message ends
        if (line.equals(endPattern)) {
            // Collect if needle was contained
            if (messageContainedNeedle) {
                result.add(currentMessage);
            }

            // Prepare for next message
            messageContainedNeedle = false;
            currentMessage = new ArrayList<>();
        }
    }
}