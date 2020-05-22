public void copy(String origenArchivo, Path algo)
throws IOException {
    Path origenPath = Paths.get(origenArchivo);
    Path conv = algo.resolve(origenPath.getFileName());
    Files.copy(origenPath, conv, StandardCopyOption.REPLACE_EXISTING);
}