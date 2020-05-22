HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);


public static String getCookie(HttpServletRequest request, String name) {

    String value = null;

    try {

        for (Cookie c : request.getCookies()) {
            if (c.getName().equals(name)) {
                value = c.getValue();
            }
        }

    } catch (Exception e) {
        Logger.getLogger(StrutsUtils.class.getName()).log(Level.INFO, "message", e);
    }

    return value;
}