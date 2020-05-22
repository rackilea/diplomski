public static String getWebappUrl(ServletConfig servletConfig, boolean ssl) {
    String protocol = ssl ? "https" : "http";
    String host = getHostName();
    String context = servletConfig.getServletContext().getServletContextName();
    return protocol + "://" + host + "/" + context;
}

public static String getHostName() {
    String[] hostnames = getHostNames();
    if (hostnames.length == 0) return "localhost";
    if (hostnames.length == 1) return hostnames[0];
    for (int i = 0; i < hostnames.length; i++) {
        if (!"localhost".equals(hostnames[i])) return hostnames[i];
    }
    return hostnames[0];
}

public static String[] getHostNames() {
    String localhostName;
    try {
        localhostName = InetAddress.getLocalHost().getHostName();
    } catch (UnknownHostException ex) {
        return new String[] {"localhost"};
    }
    InetAddress ia[];
    try {
        ia = InetAddress.getAllByName(localhostName);
    } catch (UnknownHostException ex) {
        return new String[] {localhostName};
    }
    String[] sa = new String[ia.length];
    for (int i = 0; i < ia.length; i++) {
        sa[i] = ia[i].getHostName();
    }
    return sa;
}