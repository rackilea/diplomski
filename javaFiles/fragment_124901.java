public class Velocity2LayoutView extends VelocityLayoutView {
    ViewToolManager toolManager;

    @Override
    protected Context createVelocityContext(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        ViewToolContext context = toolManager.createContext(request, response);
        context.putAll(model);
        return context;
    }

    @Override
    protected void initTool(Object tool, Context velocityContext) throws Exception {
        //super.initTool(tool, velocityContext);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        toolManager = new ViewToolManager(getServletContext(), false, false);
        if (getToolboxConfigLocation() != null) {
            String path = getToolboxConfigLocation();
            logger.debug("Init ViewToolManager with " + path);
            XmlFactoryConfiguration config = new XmlFactoryConfiguration();
            config.read(getServletContext().getResourceAsStream(getToolboxConfigLocation()));
            toolManager.configure(config);
        }
        toolManager.setVelocityEngine(getVelocityEngine());
    }
}