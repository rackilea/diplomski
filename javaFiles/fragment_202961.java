/**
 * Used to handle module {@link ModelAndView}.<br/><br/>
 * <b>Usage:</b><br/>{@code new ModuleAndView("module:MODULE_NAME.jar:LOCATION");}<br/><br/>
 * <b>Example:</b><br/>{@code new ModuleAndView("module:test-module.jar:views/testModule");}
 * @see JstlView
 * @author Ludovic Guillaume
 */
public class ModuleJstlView extends JstlView {
    @Override
    protected String prepareForRendering(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String beanName = getBeanName();

        // checks if it starts 
        if (beanName.startsWith("module:")) {
            String[] values = beanName.split(":");

            String location = String.format("/%s%s/WEB-INF/%s", ModuleManager.CONTEXT_ROOT_MODULES_FOLDER, values[1], values[2]);

            setUrl(getUrl().replaceAll(beanName, location));
        }

        return super.prepareForRendering(request, response);
    }
}