private List<ScanFilter> scanFilters() {
    List<ScanFilter> list = new ArrayList<ScanFilter>();

    ScanFilter scanFilterName = new ScanFilter.Builder().setDeviceName(null).build();

    list.add(scanFilterName);

    return list;
}