public class MyFreemarkerManager extends
    org.apache.struts2.views.freemarker.FreemarkerManager {

private static final Logger LOG = LoggerFactory
        .getLogger(MyFreemarkerManager.class);

@Override
public void init(ServletContext servletContext) throws TemplateException {
    config = createConfiguration(servletContext);

    // Set defaults:
    config.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
    contentType = DEFAULT_CONTENT_TYPE;

    // Process object_wrapper init-param out of order:
    wrapper = createObjectWrapper(servletContext);
    if(LOG.isDebugEnabled()) {
        LOG.debug("Using object wrapper of class " + wrapper.getClass().getName());
    }
    config.setObjectWrapper(wrapper);

    // Process TemplatePath init-param out of order:
    templatePath = servletContext.getInitParameter(INITPARAM_TEMPLATE_PATH);
    if(templatePath == null) {
        templatePath = servletContext.getInitParameter("templatePath");
    }

    config
            .setTemplateLoader(createTemplateLoader(servletContext, templatePath));

    loadSettings(servletContext);
}

@Override
protected Configuration createConfiguration(ServletContext servletContext)
        throws TemplateException {
    Configuration configuration = new Configuration();

    configuration
            .setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);

    if(mruMaxStrongSize > 0) {
        configuration.setSetting(Configuration.CACHE_STORAGE_KEY, "strong:"
                + mruMaxStrongSize);
    }
    if(templateUpdateDelay != null) {
        configuration.setSetting(Configuration.TEMPLATE_UPDATE_DELAY_KEY,
                templateUpdateDelay);
    }
    if(encoding != null) {
        configuration.setDefaultEncoding(encoding);
    }

    configuration.setWhitespaceStripping(true);

    return configuration;
}
}