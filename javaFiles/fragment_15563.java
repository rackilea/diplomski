final static String timestampRgx = "(?<timestamp>\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3})";
final static String levelRgx = "(?<level>INFO|ERROR|WARN|TRACE|DEBUG|FATAL)";
final static String classRgx = "\\[(?<class>[^\\]]+)]";
final static String threadRgx = "\\[(?<thread>[^\\]]+)]";
final static String textRgx = "(?<text>.*?)(?=\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2},\\d{3}|\\Z)";
private static Pattern PatternFullLog = Pattern.compile(timestampRgx + " " + levelRgx + "\\s+" + classRgx + "-" + threadRgx + "\\s+" + textRgx, Pattern.DOTALL);