public class SpringWACListener implements ServletContextAttributeListener {
    public void attributeAdded(ServletContextAttributeEvent scab) {
        if (WebApplicationContext.
            ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE.
            equals(scab.getName()) {
            myCentralisedMonitor.notify("added");
        }
    }
    // same for others
}