private static String loadString(File f) {
    StringBuffer results = new StringBuffer();
    try (Reader reader = new BufferedReader(new InputStreamReader(new FileInputStream(f)))) {
        ...
        while (reader.read(data) >= 0) {
            ... 
        }
    } catch (IOException e) {
        logger.warn(....);
        for (Throwable ex : e.getSuppressed())
            logger.warn(....);
    }
    return results.toString();
}