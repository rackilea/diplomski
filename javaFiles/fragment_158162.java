@Service("customRequestCache")
public class CustomRequestCache extends HttpSessionRequestCache { //this class (bean) is used by spring security

    @Override
    public void saveRequest(HttpServletRequest request, HttpServletResponse response) {
        if (!"XMLHttpRequest".equalsIgnoreCase(request.getHeader("X-Requested-With"))) {
            //request is not ajax, we can store it
            super.saveRequest(request, response);
        } else {
            //do nothing, add some logs if you want
        }
    }
}