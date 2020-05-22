private static String run(String... cmds) throws IOException {
    ProcessBuilder pb = new ProcessBuilder(cmds);
    pb.redirectErrorStream(true);
    Process process = pb.start();
    StringWriter sw = new StringWriter();
    char[] chars = new char[1024];
    try (Reader r = new InputStreamReader(process.getInputStream())) {
        for (int len; (len = r.read(chars)) > 0; ) {
            sw.write(chars, 0, len);
        }
    }
    return sw.toString();
}