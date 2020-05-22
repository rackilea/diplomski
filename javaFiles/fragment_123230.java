private void freshen() {
    if (mLEScanner != null)
        mLEScanner.stopScan(mScanCallback);
    ScanSettings settings = new ScanSettings.Builder()
            .setScanMode(ScanSettings.SCAN_MODE_LOW_LATENCY)
            .setNumOfMatches(ScanSettings.MATCH_NUM_ONE_ADVERTISEMENT)
            .build();

    List<ScanFilter> filters = new ArrayList<>();

    ScanFilter filter = new ScanFilter.Builder()
            .setDeviceName("" + (reading % 10))
            .build();

    filters.add(filter);

    mLEScanner.startScan(filters, settings, mScanCallback);
}