final Intent intent = new Intent("org.magiclen.barcodescanner.SCAN");
final List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent, PackageManager.GET_ACTIVITIES);
if (list.size() > 0) {
    intent.putExtra("SCAN_MODE", "QR_CODE_MODE"); // Can also use PRODUCT_MODE, SCAN_MODE,     QR_CODE_MODE
    startActivityForResult(intent, 0);
} else {
    // You may ask your user to install Easy Barcode Scanner
}