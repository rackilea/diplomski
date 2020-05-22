@ServiceProvider(service = ContextGlobalProvider.class,
    //this next arg is nessesary if you want yours to be the default
    supersedes = "org.netbeans.modules.openide.windows.GlobalActionContextImpl")
public class CentralLookup implements ContextGlobalProvider{
    private final InstanceContent content = new InstanceContent();
    private final Lookup lookup = new AbstractLookup(content);
    public CentralLookup() {}

    public void add(Object instance){
        content.add(instance);
    }

    public void remove(Object instance){
        content.remove(instance);
    }

    public static CentralLookup getInstance() {
        return CentralLookupHolder.INSTANCE;
    }

    // this is apperently only called once...
    @Override
    public Lookup createGlobalContext() {
        return lookup;
    }
    private static class CentralLookupHolder {
        //private static final CentralLookup INSTANCE = new CentralLookup();
        private static final CentralLookup INSTANCE = Lookup.getDefault().lookup(CentralLookup.class);
    }
}