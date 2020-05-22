@Singleton
@Visibility(DescriptorVisibility.LOCAL)
public class GreedyResolver implements JustInTimeInjectionResolver {
    private final ServiceLocator locator;

    @Inject
    private GreedyResolver(ServiceLocator locator) {
        this.locator = locator;
    }

    @Override
    public boolean justInTimeResolution(Injectee failedInjectionPoint) {
        Type type = failedInjectionPoint.getRequiredType();
        if (type == null) return false;

        Class<?> clazzToAdd = null;
        if (type instanceof Class) {
            clazzToAdd = (Class<?>) type;
        }
        else if (type instanceof ParameterizedType) {
            Type rawType = ((ParameterizedType) type).getRawType();
            if (rawType instanceof Class) {
                clazzToAdd = (Class<?>) rawType;
            }
        }

        if (clazzToAdd == null) return false;
        if (clazzToAdd.isInterface()) return false;

        ServiceLocatorUtilities.addClasses(locator, clazzToAdd);
        return true;
    }

}