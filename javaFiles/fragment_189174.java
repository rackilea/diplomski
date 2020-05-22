class WhitelistMetricFilter implements MetricFilter {
    private final Set<String> whitelist;

    public WhitelistMetricFilter(Set<String> whitelist) {
        this.whitelist = whitelist;
    }

    @Override
    public boolean matches(String name, Metric metric) {
        for (String whitelisted: whitelist) {
            if (whitelisted.endsWith(name))
                return true;
        }
        return false;
    }
}