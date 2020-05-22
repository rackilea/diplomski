try (Reader in = new BufferedReader(
    new InputStreamReader(
        Main.class.getResourceAsStream(
            "/counter/res/ResourceCounterPatchNotes.txt"),
        StandardCharsets.UTF_8))) {
    ta.read(in);
}