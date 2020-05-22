abstract class BaseClass {

    abstract void basePrepare(Configuration configuration, Logger logger);

    protected boolean prepareDirectory(Configuration configuration, Logger logger) throws Exception {
    if (/* condition */) {
        basePrepare(configuration, logger); // implementing class does his stuff
      }
    }
}