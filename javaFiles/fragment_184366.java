public class CustomRunner extends BlockJUnit4ClassRunner {
    public CTRunner(Class<?> klass) throws initializationError {
        super(klass);
    }

    @Override
    protected boolean isIgnored(FrameworkMethod child) {
        if(shouldIgnore()) {
            return true;
        }
        return super.isIgnored(child);
    }

    private boolean shouldIgnore(class) {
        /* some custom criteria */
    }
}