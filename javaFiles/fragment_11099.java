public class ProgramCreator {
    private PersistenceManagerFactory pm_factory;
    private ProgramFactory p_factory;

    public ProgramCreator(PersistenceManagerFactory pm_factory, ProgramFactory pFactory) {
        this.pm_factory = pm_factory;
        this.p_factory = pFactory;
    }

    public void createProgram(String name, String instructor, double price) {
        PersistenceManager pm = getPersistenceManager();
        try {
            pm.makePersistent(p_Factory.createProgram(name, instructor, price));
        } finally {
            pm.close();
        }
    }
}