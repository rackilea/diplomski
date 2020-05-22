final class EmbeddedEngineHandler {

    private static final String PREFIX = ""; // some ID for your library here
    private static final String IS_SERVLET_CONTEXT = PREFIX + "-is-servlet-context";
    private static final String GLOBAL_ENGINE_LOADED = PREFIX + "-global-engine-loaded";

    private static final String TRUE = "true";

    private static volatile boolean localEngineLoaded = false;

    // LOADING
    static void loadEmbeddedEngineIfNeeded() {
        if (isServletContext()) {
            // handles only engine per container case
            loadEmbeddedEngineInLocalContextIfNeeded();
        } else {
            // handles both normal Java application & global driver cases
            loadEmbeddedEngineInGlobalContextIfNeeded();
        }

    }

    private static void loadEmbeddedEngineInLocalContextIfNeeded() {
        if (!isGlobalEngineLoaded() && !isLocalEngineLoaded()) { // will not load if we have a global driver
            loadEmbeddedEngine();
            markLocalEngineAsLoaded();
        }
    }

    private static void loadEmbeddedEngineInGlobalContextIfNeeded() {
        if (!isGlobalEngineLoaded()) {
            loadEmbeddedEngine();
            markGlobalEngineAsLoaded();
            Runtime.getRuntime().addShutdownHook(new Thread(EmbeddedEngineHandler::unloadEmbeddedEngine));
        }
    }

    private static void loadEmbeddedEngine() {
    }

    static void unloadEmbeddedEngine() {
    }

    // SERVLET CONTEXT (state shared between containers)
    private static boolean isServletContext() {
        return TRUE.equals(System.getProperty(IS_SERVLET_CONTEXT));
    }

    static void markAsServletContext() {
        System.setProperty(IS_SERVLET_CONTEXT, TRUE);
    }

    // GLOBAL ENGINE (state shared between containers)
    private static boolean isGlobalEngineLoaded() {
        return TRUE.equals(System.getProperty(GLOBAL_ENGINE_LOADED));
    }

    private static void markGlobalEngineAsLoaded() {
        System.setProperty(GLOBAL_ENGINE_LOADED, TRUE);
    }

    // LOCAL ENGINE (container-specific state)
    static boolean isLocalEngineLoaded() {
        return localEngineLoaded;
    }

    private static void markLocalEngineAsLoaded() {
        localEngineLoaded = true;
    }
}