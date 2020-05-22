public static void setCookie(HttpServletResponse response, String name, String value, int period) {

    try {

        Cookie div = new Cookie(name, value);
        div.setMaxAge(60 * 60 * 24 * 365); // Make the cookie last a year
        response.addCookie(div);

    } catch (Exception e) {
        Logger.getLogger(StrutsUtils.class.getName()).log(Level.INFO, "message", e);
    }
}