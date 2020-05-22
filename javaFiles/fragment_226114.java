public class MethodRequestMatcher implements RequestMatcher {
    private RequestMethod method;

    public MethodRequestMatcher(RequestMethod method) {
        this.method = method;
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        if (method == null) {
            return false;
        }
        return request.getMethod().equals(method.name());

    }
}