public class RestyDispatcher extends DefaultFilterawareDispatcher {

    public RestyDispatcher() {
        addFilter(new ForbiddenDispatcherFilter());
        addFilter(new BasicAuthHeaderDispatcherFilter());
    }

    @Override
    public Request send(Method method, RequestBuilder builder) throws RequestException {
         return super.send(method, builder);
    }

}