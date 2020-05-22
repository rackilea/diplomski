// for lineEnding, use "<br>" for HTML, "\n" for text
public static final String getStackTrace(Throwable t, String lineEnding) {
    Object[] stackTrace = t.getStackTrace();
    if (stackTrace != null) {
        StringBuilder output = new StringBuilder();
        for (Object line : stackTrace) {
            output.append(line);
            output.append(lineEnding);
        }
        return output.toString();
    } else {
        return "[stack unavailable]";
    }
}