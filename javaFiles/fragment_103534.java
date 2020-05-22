@Override
public void handleResult(Result result) {

    System.out.print("BAR_CODE  "+ result.getContents());
    System.out.print("BAR_CODEE  "+result.getBarcodeFormat().getName());
    barcode_number = result.getContents();
    productcode.setText(result.getContents());

    //resume Camera
    scanner_bar.resumeCameraPreview(this);

    dialog = new ProgressDialog(getActivity());
    dialog.setCancelable(true);
    dialog.setTitle("Loading");
    dialog.show();

    //callApi
    if(barcode_number != "") {
        scanner_bar.stopCamera(); 
        callApi(barcode_number);
    }

};