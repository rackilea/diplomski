public class CallingActivity extends Activity {

    private static final String TAG = CallingActivity.class.getSimpleName();

    private static final int BarCodeScannerViewControllerUserCanceledErrorCode = 99991;

    String uuid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        uuid = getIntent().getStringExtra("uuid");
        new IntentIntegrator(this).setOrientationLocked(false).setCaptureActivity(CustomScannerActivity.class).initiateScan();
    }



    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

        if (resultCode == RESULT_OK) {
            if (scanResult != null) {

                // handle scan result
                Log.i(TAG, "Text from Barcode Scanner: " + scanResult.getContents());
                getIntent().putExtra("data", scanResult.getContents());
                getIntent().putExtra("uuid", uuid);
            }
        }
        else if (resultCode == RESULT_CANCELED) {
            getIntent().putExtra("error", "User canceled");
            getIntent().putExtra("error_code", BarCodeScannerViewControllerUserCanceledErrorCode);
        }
        else
        {
            getIntent().putExtra("error", getString(R.string.scanner_error));
            getIntent().putExtra("error_code", BarCodeScannerViewControllerUserCanceledErrorCode);
        }

        setResult(resultCode, this.getIntent());

        this.finish();
    }

}