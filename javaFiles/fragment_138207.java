public static void main(final String[] args) {
    final Manager manager = new Manager();
    Filter f = manager.getFilter();
    f.commonMethod(); 
    if (f instanceof IpFilter)
    {
        ((IpFilter) f).specialMethod();
    }
    ...
}