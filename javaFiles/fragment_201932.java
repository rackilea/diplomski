if (finali == 0) {
    Intent intent = BarcodeReaderActivity.getLaunchIntent(getApplicationContext(), true,false);
    startActivityForResult(intent, BARCODE_READER_ACTIVITY_REQUEST_FINALI_1);
}
// ... the remaining code of finali == 1 & finali == 2
else if (finali == 3) {
    Intent intent = BarcodeReaderActivity.getLaunchIntent(getApplicationContext(), true,false);
    startActivityForResult(intent,BARCODE_READER_ACTIVITY_REQUEST_FINALI_3);
}