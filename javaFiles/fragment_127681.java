@Component
public class SubdomainToReversePathFilter implements Filter {
    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final String requestURI = req.getRequestURI();

        if (!requestURI.endsWith("/")) {
            chain.doFilter(request, response);
        } else {
            final String servername = req.getServerName();
            final Domain domain = getDomain(servername);

            if (domain.hasSubdomain()) {
                final HttpServletRequestWrapper wrapped = wrapServerName(req, domain);
                wrapped.getRequestDispatcher(requestURI + domain.getSubdomainAsPath()).forward(wrapped, response);
            } else {
                chain.doFilter(request, response);
            }
        }
    }

    private Domain getDomain(final String domain) {
        final String[] domainParts = domain.split("\\.");
        String mainDomain;
        String subDomain = null;

        final int dpLength = domainParts.length;
        if (dpLength > 2) {
            mainDomain = domainParts[dpLength - 2] + "." + domainParts[dpLength - 1];

            subDomain = reverseDomain(domainParts);
        } else {
            mainDomain = domain;
        }

        return new Domain(mainDomain, subDomain);
    }
    private HttpServletRequestWrapper wrapServerName(final HttpServletRequest req, final Domain domain) {
        return new HttpServletRequestWrapper(req) {
            @Override
            public String getServerName() {
                return domain.getMaindomain();
            }
            // more changes? getRequesetURL()? ...?
        };
    }

    private String reverseDomain(final String[] domainParts) {
        final List<String> subdomainList = Arrays.stream(domainParts, 0, domainParts.length - 2)//
                .collect(Collectors.toList());

        Collections.reverse(subdomainList);

        return subdomainList.stream().collect(Collectors.joining("."));
    }

    @Override
    public void init(final FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }
}