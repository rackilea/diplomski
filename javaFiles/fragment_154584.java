@Override
public void receiveDetections(Detector.Detections<Barcode> detections) {
    final SparseArray<Barcode> qrCodes = detections.getDetectedItems();

    if (qrCodes.size() != 0) {
        textView.post(new Runnable() {
            @Override
            public void run() {
                Vibrator vibrator = (Vibrator)getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(1000);
                textView.setText(qrCodes.valueAt(0).displayValue);
                sendMessage2(textView);
            }
        });
    }
}