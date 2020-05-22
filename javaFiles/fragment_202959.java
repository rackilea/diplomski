/**
 * Only used to keep the {@link DispatcherServlet} easily accessible by {@link WebApplicationUtils}.
 * @author Ludovic Guillaume
 */
public class ModuleDispatcherServlet extends DispatcherServlet {
    private static final long serialVersionUID = 1L;

    public ModuleDispatcherServlet() {
        WebApplicationUtils.setDispatcherServlet(this);
    }
}