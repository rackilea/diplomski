@Override
public void init() throws ServletException {
    try {
        Field wrappedConfig = StandardWrapperFacade.class.getDeclaredField("config");
        wrappedConfig.setAccessible(true);
        StandardWrapper standardWrapper = (StandardWrapper) wrappedConfig.get(getServletConfig());
        standardWrapper.setMaxInstances(100);
    } catch (Exception e) {
        throw new ServletException("Failed to increment max instances", e);
    }
}