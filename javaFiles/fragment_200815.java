@Override
protected String doInBackground() throws Exception {
    return new String(
        java.nio.file.Files.readAllBytes(file.toPath()),
        java.nio.charset.StandardCharsets.UTF_8);
}