if (System.in.available() > 0) {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    String line = " ";
    while (line != null) {
        if (!line.startsWith("#") && StringUtils.hasText(line)) {
            if (logger.isDebugEnabled()) {
                logger.debug("Stdin arg: " + line);
            }
            newargs.add(line);
        }
        line = reader.readLine();
    }
}