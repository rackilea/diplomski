static {
    System.setProperty("org.openide.util.Lookup", TestLookup.class.getName());
}

public class TestLookup extends org.openide.util.lookup.AbstractLookup {
    public TestLookup() {
        this(new org.openide.util.lookup.InstanceContent());
    }

    private TestLookup(org.openide.util.lookup.InstanceContent ic) { 
        super(ic);
        ic.add(new TestService());
    }