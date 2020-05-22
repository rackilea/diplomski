@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
    if(result != null) {
        ScanResult scanResult = new ScanResult(result);
        Intent intent1 = new Intent(getActivity(), Trial.class);
        intent1.putExtra("scanResult", scanResult);
        startActivity(intent1);
    }
}