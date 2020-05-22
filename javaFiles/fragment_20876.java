public class CustomScannerActivity extends Activity {

private CaptureManager capture;
private CompoundBarcodeView barcodeScannerView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_custom_scanner);

    barcodeScannerView = (CompoundBarcodeView)findViewById(R.id.zxing_barcode_scanner);
    capture = new CaptureManager(this, barcodeScannerView);
    capture.initializeFromIntent(getIntent(), savedInstanceState);
    capture.decode();

}

@Override
protected void onResume() {
    super.onResume();
    capture.onResume();
}

@Override
protected void onPause() {
    super.onPause();
    capture.onPause();
}

@Override
protected void onDestroy() {
    super.onDestroy();
    capture.onDestroy();
}

@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    capture.onSaveInstanceState(outState);
}

}