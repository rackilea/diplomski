public class RestyDispatcher extends DefaultFilterawareDispatcher {

    public RestyDispatcher() {
    addFilter(new ForbiddenDispatcherFilter());
    addFilter(new BasicAuthHeaderDispatcherFilter());
    }
}