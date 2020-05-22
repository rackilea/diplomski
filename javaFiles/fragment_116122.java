if (! Files.exists(configLocation)) {
    // create directory if needed
    if (! Files.exists(configLocation.getParent())) {
        Files.createDirectory(configLocation.getParent());
    }

    // extract default config from jar and copy to config location:

    try (
        BufferedReader in = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/config.properties")));
        BufferedWriter out = Files.newBufferedWriter(configLocation);) {

        in.lines().forEach(line -> {
            out.append(line);
            out.newLine();
        });
    } catch (IOException exc) {
        // handle exception, e.g. log and warn user config could not be created
    }
}

Properties config = new Properties();
try (BufferedReader in = Files.newBufferedReader(configLocation)) {
    config.load(in);
} catch (IOException exc) {
    // handle exception...
}