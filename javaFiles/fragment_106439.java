private Set<String> localAddresses = new HashSet<String>(); 

@Override
public void init(FilterConfig config) throws ServletException {
    try {
        localAddresses.add(InetAddress.getLocalHost().getHostAddress());
        for (InetAddress inetAddress : InetAddress.getAllByName("localhost")) {
            localAddresses.add(inetAddress.getHostAddress());
        }
    } catch (IOException e) {
        throw new ServletException("Unable to lookup local addresses");
    }
}

@Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
    if (localAddresses.contains(request.getRemoteAddr())) {
        // Locally accessed.
    } else {
        // Remotely accessed.
    }
}