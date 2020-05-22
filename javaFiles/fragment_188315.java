@Override
protected Filter[] getServletFilters() {
    return new Filter[] {
        new OpenEntityManagerInViewFilter();
    };
}