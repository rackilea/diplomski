public class Version {
        public static final String AS_VERSION;
        public static final String AS_RELEASE_CODENAME;
        public static final int MANAGEMENT_MAJOR_VERSION = 1;
        public static final int MANAGEMENT_MINOR_VERSION = 4;
        public static final int MANAGEMENT_MICRO_VERSION = 0;

        static {
            InputStream stream =         Version.class.getClassLoader().getResourceAsStream("META-INF/MANIFEST.MF");
            Manifest manifest = null;
            try {
                if (stream != null)
                    manifest = new Manifest(stream);
            } catch (Exception e) {
            }

            String version = null, code = version;
            if (manifest != null) {
                version = manifest.getMainAttributes().getValue("JBossAS-Release-        Version");
        code = manifest.getMainAttributes().getValue("JBossAS-Release-Codename");
    }
    if (version == null) {
        version = "Unknown";
    }
    if (code == null) {
        code = "Unknown";
    }

    AS_VERSION = version;
    AS_RELEASE_CODENAME = code;
}