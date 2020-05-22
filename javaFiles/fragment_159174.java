public class JobEnabledDecorating extends AbstractBehaviorFactory {
    @Override
    public ComponentAdapter createComponentAdapter(
        final ComponentMonitor componentMonitor, final LifecycleStrategy lifecycleStrategy,
        final Properties componentProperties, final Object componentKey,
        final Class componentImplementation, final Parameter... parameters) throws PicoCompositionException 
    {
        return componentMonitor.newBehavior(
            new JobEnabledDecorated(
                super.createComponentAdapter(
                    componentMonitor, lifecycleStrategy, componentProperties, 
                    componentKey, componentImplementation, parameters
                )
            )
        );
    }
}