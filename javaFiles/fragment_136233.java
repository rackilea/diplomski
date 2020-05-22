@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);

    barcodeScannerView = (BarcodeScannerView) findViewById(R.id.barcode_scanner);
    barcodeScannerView.setOnScannerListener(this);
}