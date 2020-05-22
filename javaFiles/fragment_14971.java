public class LocalFileTemplateLoader implements TemplateLoader {

    public File baseDir;

    @Override
    public Object findTemplateSource(String name) {
        File source = new File(baseDir, name);
        if (source.isFile()) {
            return source;
        } else {
            return null;
        }
    }

    @Override
    public long getLastModified(Object templateSource) {
        if (templateSource instanceof File) {
            return new Long(((File) templateSource).lastModified());
        } else {
            throw new IllegalArgumentException("templateSource is an unknown type: " + templateSource.getClass());
        }
    }

    @Override
    public Reader getReader(Object templateSource, String encoding) throws IOException {
        if (templateSource instanceof File) {
            return new InputStreamReader(new FileInputStream((File) templateSource), encoding);
        } else {
            throw new IllegalArgumentException("templateSource is an unknown type: " + templateSource.getClass());
        }
    }

    @Override
    public void closeTemplateSource(Object templateSource) {
        // noop
    }

    @Required
    public void setBaseDir(File baseDir) {
        this.baseDir = baseDir;
        // it may not exist yet because CMS is going to download and create it
    }
}