@Override
public Decorator getDecorator(HttpServletRequest request, Page page) {
    Decorator d = super.getDecorator(request, page);
    return getResolvedDecorator(d, d.getName(), request);

}
public Decorator getResolvedDecorator(Decorator current, String name, HttpServletRequest request) {
    if (name.equalsIgnoreCase("default")) {
        return getNamedDecorator(request, "externalPartnerDefault");
    }
    return current;
}