public Set<Mobile> search(Set<Mobile> mobiles, OperatingSystem os,
        Brand brand,Display display, Style style) {
    Set<Mobile> result = new HashSet<>();
    for (Set<Mobile> mobile: mobiles) {
        if ((os == null || os.equals(mobile.getOs()))
                && (brand == null || brand.equals(mobile.getBrand()))
                && (display == null || display.equals(mobile.getDisplay()))
                && (style == null || style.equals(mobile.getStyle()))) {
            result.add(mobile);
        }
    }
    return result;
}