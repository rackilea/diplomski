protected void doStart() throws Exception {
    setClassLoader(new LauncherWebAppClassLoader());
    super.doStart();
    ServletHolder holder = getServletHandler().getServlet("default");
    Servlet servlet = holder.getServlet();
    Field field = servlet.getClass().getDeclaredField("_resourceBase");
    field.setAccessible(true);
    field.set(servlet, combinedResourceBase);
}