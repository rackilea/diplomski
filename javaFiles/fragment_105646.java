public class CookieServlet extends org.springframework.web.servlet.mvc.AbstractController {
...
    protected ModelAndView handleRequestInternal(final HttpServletRequest req,
                                         final HttpServletResponse resp) throws Exception {
        ....
        Cookie[] cookies = req.getCookies();
        String session = null;
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("AUTHSESSION")) {
                    session = cookie.getValue();
                    break;
                }
            }
        }


        if(null!=session) {
            Cookie cookie = new Cookie("AUTHSESSION", session);
            cookie.setMaxAge(<specify cookie age>);
            resp.addCookie(cookie);
        }
        ...
    }