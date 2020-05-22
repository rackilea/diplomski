public class JobEnabledDecorated extends AbstractBehavior<Job> {
    public JobEnabledDecorated(final ComponentAdapter<Job> delegate) {
        super(delegate);
    }

    @Override
    public Job getComponentInstance(final PicoContainer container, final Type into)
            throws PicoCompositionException {
        final Job instance = super.getComponentInstance(container, into);
        return new JobEnabledDecorator(instance);
    }

    @Override
    public String getDescriptor() {
        return "JobEnabledDecorator-";
    }
}