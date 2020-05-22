@Override
protected Filter[] getServletFilters() {
    LoggingFilter requestLoggingFilter = new LoggingFilter();

    return new Filter[]{requestLoggingFilter};
}