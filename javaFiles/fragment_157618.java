public Task<List<FirebaseVisionBarcode>> ScanBarcode(int... barcodeFormats)
{
    //region Init, config and execution of the barcode scanning. Mostly taken from https://firebase.google.com/docs/ml-kit/
    final FirebaseVisionBarcodeDetectorOptions.Builder BUILDER =
            new FirebaseVisionBarcodeDetectorOptions.Builder();

    //Set barcode formats based on arguments
    for (int formats : barcodeFormats)
    {
        BUILDER.setBarcodeFormats(formats);
    }

    final FirebaseVisionBarcodeDetectorOptions OPTIONS = BUILDER.build();

    final FirebaseVisionImage IMAGE = FirebaseVisionImage.fromBitmap(bitmap);

    final FirebaseVisionBarcodeDetector DETECTOR = FirebaseVision.getInstance()
            .getVisionBarcodeDetector(OPTIONS);

    final Task<List<FirebaseVisionBarcode>> DETECT_IMG_TASK = DETECTOR.detectInImage(IMAGE)
            .addOnSuccessListener(new OnSuccessListener<List<FirebaseVisionBarcode>>()
            {
                @Override
                public void onSuccess(List<FirebaseVisionBarcode> _barcodes)
                {
                    barcodes = _barcodes;
                }
            })

            .addOnFailureListener(new OnFailureListener()
            {
                @Override
                public void onFailure(@NonNull Exception e)
                {
                    barcodes = new ArrayList<>();
                }
            });

    return DETECT_IMG_TASK;
    //endregion

}

public List<FirebaseVisionBarcode> GetBarcodes()
{
    return barcodes;
}