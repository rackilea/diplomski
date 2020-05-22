public class ResourceScanner {
    private PathMatchingResourcePatternResolver resourcePatternResolver;

    public ResourceScanner() {
        this.resourcePatternResolver = new PathMatchingResourcePatternResolver();
    }

    public Resource getResource(String path) {
        path = path.replace("\\", "/");
        return resourcePatternResolver.getResource(path);
    }

    public Resource[] getResources(String path) throws IOException {
        path = path.replace("\\", "/");
        return resourcePatternResolver.getResources(path);
    }

    public Resource[] getResourcesIn(String path) throws IOException {
        // Get root dir URI
        Resource root = getResource(path);
        String rootUri =  root.getURI().toString();

        // Search all resources under the root dir
        path = (path.endsWith("/")) ? path + "**" : path + "/**";

        // Filter only direct children
        return Arrays.stream(getResources(path)).filter(resource -> {
            try {
                String uri = resource.getURI().toString();

                boolean isChild = uri.length() > rootUri.length() && !uri.equals(rootUri + "/");
                if (isChild) {
                    boolean isDirInside = uri.indexOf("/", rootUri.length() + 1) == uri.length() - 1;
                    boolean isFileInside = uri.indexOf("/", rootUri.length() + 1) == -1;
                    return isDirInside || isFileInside;
                }

                return false;
            } catch (IOException e) {
                return false;
            }
        }).toArray(Resource[]::new);
    }

    public String[] getResourcesNamesIn(String path) throws IOException {
        // Get root dir URI
        Resource root = getResource(path);
        String rootUri = URLDecoder.decode(root.getURI().toString().endsWith("/") ? root.getURI().toString() : root.getURI().toString() + "/", "UTF-8");

        // Get direct children names
        return Arrays.stream(getResourcesIn(path)).map(resource -> {
            try {
                String uri = URLDecoder.decode(resource.getURI().toString(), "UTF-8");

                boolean isFile = uri.indexOf("/", rootUri.length()) == -1;
                if (isFile) {
                    return uri.substring(rootUri.length());
                } else {
                    return uri.substring(rootUri.length(), uri.indexOf("/", rootUri.length() + 1));
                }
            } catch (IOException e) {
                return null;
            }
        }).toArray(String[]::new);
    }
}