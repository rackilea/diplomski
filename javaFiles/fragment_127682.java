public static class Domain {
    private final String maindomain;
    private final String subdomain;

    public Domain(final String maindomain, final String subdomain) {
        this.maindomain = maindomain;
        this.subdomain = subdomain;
    }

    public String getMaindomain() {
        return maindomain;
    }

    public String getSubdomain() {
        return subdomain;
    }

    public boolean hasSubdomain() {
        return subdomain != null;
    }

    public String getSubdomainAsPath() {
        return "/" + subdomain.replaceAll("\\.", "/") + "/";
    }
}