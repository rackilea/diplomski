public void onActivityResult(int requestCode, int resultCode, Intent intent) {
IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);

//Places barcode in the scan_content editext


Log.e("editTextNumber",""+ editTextNumber ); // check whats value here
if (scanningResult != null && editTextNumber == 1) { // checking for flag here
    String scanContent = scanningResult.getContents();
    contentTxt.setText(scanContent);
}

//places bar code in the scan_content2 edittext
else if (scanningResult !=null && editTextNumber == 2) {  // checking for flag also
    String scanContent = scanningResult.getContents();
    contentTxt2.setText(scanContent);
}


else{
    Toast toast = Toast.makeText(getApplicationContext(),
            "No scan data received!", Toast.LENGTH_SHORT);
    toast.show();
   }

}