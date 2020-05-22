public String readToString(InputStream stream) {

    try (InputStreamReader reader = new InputStreamReader(stream);
            BufferedReader br = new BufferedReader(reader)) {

        return br.lines().collect(Collectors.joining("\n"));

    } catch (IOException e) {
        e.printStackTrace();
        throw new RuntimeException(e);
    }
}