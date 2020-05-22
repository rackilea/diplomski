private String resourceToPath(Resource resource) {
        try {
            return resource.getFile().getAbsolutePath();
        }
        catch (IOException ex) {
            throw new IllegalStateException("Resource '" + resource + "' must be on a file system", ex);
        }