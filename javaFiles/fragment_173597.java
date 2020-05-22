@ServiceProvider(service = ContextGlobalProvider.class,
    //this next arg is nessesary if you want yours to be the default
    supersedes = "org.netbeans.modules.openide.windows.GlobalActionContextImpl")
public class CentralLookup implements ContextGlobalProvider, Lookup.Provider{
    public CentralLookup() {}

    public void add(Object instance){
        getCurrentDocument().content.add(instance);
    }

    public void remove(Object instance){
        getCurrentDocument().content.remove(instance);
    }

    public static CentralLookup getInstance() {
        return CentralLookupHolder.INSTANCE;
    }

    // this is apperently only called once...
    @Override
    public Lookup createGlobalContext() {
        return Lookups.proxy(this);
    }

    @Override
    public Lookup getLookup(){
        return getCurrentDocument().lookup;
    }
    /**
     * Refresh which lookup is current.  Call this after changing the current document
     */
    public void updateLookupCurrent(){
        Utilities.actionsGlobalContext().lookup(ActionMap.class);
    }
    private static class CentralLookupHolder {
        //private static final CentralLookup INSTANCE = new CentralLookup();
        private static final CentralLookup INSTANCE = Lookup.getDefault().lookup(CentralLookup.class);
    }
}