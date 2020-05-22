@RequestMapping(value = "/robots.txt")
public void robots(HttpServletRequest request, HttpServletResponse response) {
    try {
        response.getWriter().write("User-agent: *\nDisallow: /\n");
    } catch (IOException e) {
        CustomLogger.info(TAG, "robots", "robots(): "+e.getMessage());
    }
}