public class IntegrationServiceLoader {
    public static <T> ServiceLoader<T> loadIntegrations(Path path, Class<T> clazz) {
        List<URL> fileNames = new ArrayList<>();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            for (Path each : directoryStream) {
                fileNames.add(each.toUri().toURL());
            }
        } catch (IOException ex) {
        }
        URL[] array = fileNames.stream().toArray(size -> new URL[size]);
        ClassLoader cl = new URLClassLoader(array, IntegrationServiceLoader.class.getClassLoader());
        return ServiceLoader.load(clazz, cl);
    }
}