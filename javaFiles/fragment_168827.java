public class Foo {
private static final String LIB_BIN = "/lib-bin/";
private final static Log logger = LogFactory.getLog(ACWrapper.class);
private final static String ACWRAPPER = "acwrapper";
private final static String AAMAPI = "aamapi51";
private final static String LIBEAU = "libeay32";

static {
    logger.info("Loading DLL");
    try {
        System.loadLibrary(ACWRAPPER);
        logger.info("DLL is loaded from memory");
    } catch (UnsatisfiedLinkError e) {
        loadFromJar();
    }
}

/**
 * When packaged into JAR extracts DLLs, places these into
 */
private static void loadFromJar() {
    // we need to put both DLLs to temp dir
    String path = "AC_" + new Date().getTime();
    loadLib(path, ACWRAPPER);
    loadLib(path, AAMAPI);
    loadLib(path, LIBEAU);
}

/**
 * Puts library to temp dir and loads to memory
 */
private static void loadLib(String path, String name) {
    name = name + ".dll";
    try {
        // have to use a stream
        InputStream in = ACWrapper.class.getResourceAsStream(LIB_BIN + name);
        // always write to different location
        File fileOut = new File(System.getProperty("java.io.tmpdir") + "/" + path + LIB_BIN + name);
        logger.info("Writing dll to: " + fileOut.getAbsolutePath());
        OutputStream out = FileUtils.openOutputStream(fileOut);
        IOUtils.copy(in, out);
        in.close();
        out.close();
        System.load(fileOut.toString());
    } catch (Exception e) {
        throw new ACCoreException("Failed to load required DLL", e);
    }
}
    // blah-blah - more stuff
}