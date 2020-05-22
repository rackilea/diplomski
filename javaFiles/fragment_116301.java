public class ExcludingInternalResourceViewResolver extends
        InternalResourceViewResolver {

    private String excludePrefix;

    @Override
    public View resolveViewName(String viewName, Locale locale)
            throws Exception {

        if (this.excludePrefix != null && viewName.startsWith(this.excludePrefix)) {
            return null;
        }

        return super.resolveViewName(viewName, locale);
    }

    public void setExcludePrefix(String excludePrefix) {
        this.excludePrefix = excludePrefix;
    }
}