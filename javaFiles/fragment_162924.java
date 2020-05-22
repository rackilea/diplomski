ServletContext context = getServletConfig().getServletContext(); //ONLY if you're inside a Servlet.
String[] paths = context.getResourcePaths();
if (paths != null) {
    for (String path : paths) {
        URL resource = context.getResource(path);

        //BLAH BLAH BLAH here
    }
}