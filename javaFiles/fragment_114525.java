public final class RInterfaceHL {

    /**
     * Private constructor prevents instantiation from other classes.
     */
    private RInterfaceHL() { }

    /**
     * R REPL (read-evaluate-parse loop) handler.
     */
    private static RMainLoopCallbacks rloopHandler = null;

    /**
     * SingletonHolder is loaded, and the static initializer executed, 
     * on the first execution of Singleton.getInstance() or the first 
     * access to SingletonHolder.INSTANCE, not before.
     */
    private static final class SingletonHolder {

        /**
         * Singleton instance, with static initializer.
         */
        private static final RInterfaceHL INSTANCE = initRInterfaceHL();

        /**
         * Initialize RInterfaceHL singleton instance using rLoopHandler from
         * outer class.
         * 
         * @return RInterfaceHL instance
         */
        private static RInterfaceHL initRInterfaceHL() {
            try {
                return new RInterfaceHL(rloopHandler);
            } catch (REngineException e) {
                // a static initializer cannot throw exceptions
                // but it can throw an ExceptionInInitializerError
                throw new ExceptionInInitializerError(e);
            }
        }

        /**
         * Prevent instantiation.
         */
        private SingletonHolder() {
        }

        /**
         * Get singleton RInterfaceHL.
         * 
         * @return RInterfaceHL singleton.
         */
        public static RInterfaceHL getInstance() {
            return SingletonHolder.INSTANCE;
        }

    }

    /**
     * Return the singleton instance of RInterfaceHL. Only the first call to
     * this will establish the rloopHandler.
     * 
     * @param rloopHandler
     *            R REPL handler supplied by client.
     * @return RInterfaceHL singleton instance
     * @throws REngineException
     *             if REngine cannot be created
     */
    public static RInterfaceHL getInstance(RMainLoopCallbacks rloopHandler)
            throws REngineException {
        RInterfaceHL.rloopHandler = rloopHandler;

        RInterfaceHL instance = null;

        try {
            instance = SingletonHolder.getInstance();
        } catch (ExceptionInInitializerError e) {

            // rethrow exception that occurred in the initializer
            // so our caller can deal with it
            Throwable exceptionInInit = e.getCause();
            throw new REngineException(null, exceptionInInit.getMessage());
        }

        return instance;
    }

    /**
     * org.rosuda.REngine.REngine high level R interface.
     */
    private REngine rosudaEngine = null;

    /**
     * Construct new RInterfaceHL. Only ever gets called once by
     * {@link SingletonHolder.initRInterfaceHL}.
     * 
     * @param rloopHandler
     *            R REPL handler supplied by client.
     * @throws REngineException
     *             if R cannot be loaded.
     */
    private RInterfaceHL(RMainLoopCallbacks rloopHandler)
            throws REngineException {

        // tell Rengine code not to die if it can't
        // load the JRI native DLLs. This allows
        // us to catch the UnsatisfiedLinkError
        // ourselves
        System.setProperty("jri.ignore.ule", "yes");

        rosudaEngine = new JRIEngine(new String[] { "--no-save" }, rloopHandler);
    }
}