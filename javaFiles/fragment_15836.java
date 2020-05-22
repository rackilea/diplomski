public class CookieTrackingRedirectStrategy extends DefaultRedirectStrategy {

    @Override
    public boolean isRedirected(final HttpRequest request, final HttpResponse response, final HttpContext context) throws ProtocolException {
        boolean isRedirected = super.isRedirected(request, response, context);
        List<String> allCookies = (List<String>) context.getAttribute("all-cookies");
        if(isRedirected) {
            // Store cookies from this response for future restoration
            if(allCookies == null) {
                allCookies = new ArrayList<>();
                context.setAttribute("all-cookies", allCookies);
            }
            Header[] cookies = response.getHeaders("set-cookie");
            for(Header cookie : cookies) {
                allCookies.add(cookie.getValue());
            }
        } else if(allCookies != null) {
            // Restore all cookies to this response
            for(String cookie : allCookies) {
                response.addHeader("set-cookie", cookie);
            }
        }
        return isRedirected;
    }
}