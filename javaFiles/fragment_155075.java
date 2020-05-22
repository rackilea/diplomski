public class OverrideInputTypeResourceFilterFactory implements ResourceFilterFactory {

    @Override
    public List<ResourceFilter> create(AbstractMethod am) {
        // documented to only be AbstractSubResourceLocator, AbstractResourceMethod, or AbstractSubResourceMethod
        if (am instanceof AbstractSubResourceLocator) {
            // not actually invoked per request, nothing to do
            log.debug("Ignoring AbstractSubResourceLocator {}", am);
            return null;
        } else if (am instanceof AbstractResourceMethod) {
            OverrideInputType annotation = am.getAnnotation(OverrideInputType.class);
            if (annotation == null) {
                annotation = am.getResource().getAnnotation(OverrideInputType.class);
            }
            if (annotation != null) {
                return Lists.<ResourceFilter>newArrayList(
                    new OverrideInputTypeResourceFilter(annotation.value(), annotation.except()));
            }
        } else {
            log.warn("Got an unexpected instance of {}: {}", am.getClass().getName(), am);
        }
        return null;
    }

}