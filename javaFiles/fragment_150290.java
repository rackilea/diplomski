@Component
class FileLoaderFactory {

    // it would collect all loaders available in the content
    private @Autowired Map<String, FileLoader> loaders;

    public FileLoader getFileLoaderByFileType(String type) {
        return loaders.get(type);
    }

}