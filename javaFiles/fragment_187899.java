HttpServletResponse resp = (HttpServletResponse) Executions.getCurrent().getNativeResponse();
for(Cookie c : cookies) {
        if(c.getName().equals(COOKIE_MODE)) {
            externalAccess = Boolean.parseBoolean(c.getValue());             
            c.setMaxAge(0);
            c.setValue(null);
            c.setPath(NAMESPACE);
            resp.addCookie(c);
        } 
}