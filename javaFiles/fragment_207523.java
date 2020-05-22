@RequestMapping(value = { "/something", "/otherThing" })
public void polymorpHandlerMethod(HttpServletRequest request) {
    if (request.getContextPath().startsWith("/something")) {
        // do stuff
    } else if (request.getContextPath().startsWith("/otherThing")) {
        // do more stuff
    }
}