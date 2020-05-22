public class OrderedRunner extends BlockJUnit4ClassRunner {

    public OrderedRunner(Class klass) throws InitializationError {
        super(klass);
    }

    @Override
    protected List computeTestMethods() {
        List list = super.computeTestMethods();
        List copy = new ArrayList(list);
        Collections.sort(copy, new Comparator() {
            public int compare(FrameworkMethod o1, FrameworkMethod o2) {
                return o2.getName().compareTo(o1.getName());
            }
        });
        return copy;
    }
}