public class ScannerActivity extends Activity {

ResultHandler resultHandler;
Parameters parameters;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    IntentIntegrator integrator = new IntentIntegrator(this);
    integrator.setCaptureActivity(CustomScannerActivity.class);
    integrator.initiateScan();
}


@Override
public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    Log.d("onActivityResult", "onActivityResult: .");
    if (resultCode == Activity.RESULT_OK) {
        IntentResult scanResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        String re = scanResult.getContents();
        String message = re;
        Log.d("onActivityResult", "onActivityResult: ." + re);
        Result handlerResult = new Result(Result.STATUS_SUCCESS, "qrcode", message);
        resultHandler.onHandleResult(handlerResult);
    }
    // else continue with any other code you need in the method
    this.finish();

}