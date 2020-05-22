@Override
public void onBuildHeaders(List<Header> target) {
    //loadHeadersFromResource(R.xml.prefs_sync_plugins, target);

    Header customHeader = new Header();
    customHeader.titleRes= R.string.customHeaderTitle;
    customHeader.id = R.string.customHeaderTitle;
    target.add(customHeader);
}

@Override
public void onHeaderClick(Header header, int position) {
    if (header.id == R.string.customHeaderTitle) {
        // Do something
    }
}