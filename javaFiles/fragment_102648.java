public String onActivityResult(int requestCode, int resultCode, Intent intent) {
IntentResult scanBarcodeResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
if(scanBarcodeResult != null){
    String strResult;
    strResult = scanBarcodeResult.getContents();
    //Add these lines
    Intent intent = new Intent();
    Bundle b = new Bundle();
    b.putString("myResult", strResult);
    intent.putExtras(b);
    setResult(SUCCESS_RETURN_CODE, intent);
    finish();
    //-------------
    return strResult;
}
else{
    return null;
}