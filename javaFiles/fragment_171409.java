public class HttpServletRequestFactory implements Factory<HttpServlet> {

    @Override
    public HttpServletRequest provide() {
       return RequestHelper.getMockServletRequest();
    }

    @Override
    public void dispose(HttpSession t) {
    }
}