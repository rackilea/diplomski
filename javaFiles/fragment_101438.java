public static String getApplicationVersion() {
        String version = null;
        try {
            final List<VersionsUtil.Version> moduleVersions = VersionsUtil.getModuleVersions(Thread.currentThread().getContextClassLoader());
            for (VersionsUtil.Version moduleVersion : moduleVersions) {
                if (moduleVersion.name.equals("<NAME OF ARTIFACT TO GET>")) {
                    version = moduleVersion.version;
                    break;
                }
            }
        } catch (IOException e) {
            // We'll return null...
        }
        return version;
    }


public class VersionsUtil {
    private static final Logger LOG = LoggerFactory.getLogger(VersionsUtil.class);

    /**
     * Returns a list of the module versions available for the given class loader.
     *
     * @param classLoader the class loader to return module versions for
     * @return a list of module versions
     * @throws IOException in case there's an error reading the manifest
     */
    public static List<Version> getModuleVersions(final ClassLoader classLoader) throws IOException {
        return processResources(classLoader.getResources("META-INF/MANIFEST.MF"));
    }

    private static List<Version> processResources(final Enumeration<URL> resources) throws IOException {
        final List<Version> moduleVersions = new ArrayList();
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            Version v = process(resource);
            if (v != null) {
                moduleVersions.add(v);
            }
        }
        return moduleVersions;
    }

    private static Version process(final URL resource) {
        try {
            Properties p = readResource(resource);
            return createVersion(p);
        } catch (IOException e) {
            LOG.warn("Failed to read resource: " + resource, e);
            return null;
        }
    }

    private static Version createVersion(final Properties p) {
        Object name = p.get("Name");
        if (name != null) {
            return new Version((String) name, (String) p.get("Version"));
        }
        return null;
    }

    private static Properties readResource(final URL resource) throws IOException {
        LOG.trace("Reading resource: " + resource);
        InputStream is = resource.openStream();
        Properties p = new Properties();
        p.load(is);
        is.close();
        return p;
    }

    public static final class Version {
        String name;
        String version;

        private Version(final String name, final String version) {
            this.name = name;
            this.version = version;
        }

    }
}