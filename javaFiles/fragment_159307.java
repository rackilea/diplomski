private void scanBarcode() {
    mCameraView.setZOrderMediaOverlay(true);
    mHolder = mCameraView.getHolder();
    mBarcode = new BarcodeDetector.Builder(this).setBarcodeFormats(Barcode.ALL_FORMATS | Barcode.EAN_13 | Barcode.EAN_8 | Barcode.UPC_A | Barcode.UPC_E | Barcode.CODE_39 | Barcode.CODE_93 |
            Barcode.CODE_128 | Barcode.ITF | Barcode.CODABAR | Barcode.ISBN | Barcode.QR_CODE | Barcode.DATA_MATRIX | Barcode.PDF417 | Barcode.AZTEC).build();

    if (!mBarcode.isOperational()) {
        Toast.makeText(getApplicationContext(), "Sorry,Couldn't setup the detector", Toast.LENGTH_LONG).show();
        this.finish();
    }

    mCameraSource = new CameraSource.Builder(this, mBarcode)
            .setFacing(CameraSource.CAMERA_FACING_BACK)
            .setRequestedFps(15.0f)
            .setAutoFocusEnabled(true)
            .setRequestedPreviewSize(1600, 1024)
            .build();
    mCameraView.getHolder().addCallback(new SurfaceHolder.Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            try {
                if (ContextCompat.checkSelfPermission(ScanActivity.this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED) {
                    mCameraSource.start(mCameraView.getHolder());
                } else {
                    ActivityCompat.requestPermissions(ScanActivity.this, new String[]{Manifest.permission.CAMERA}, PERMISSION_REQUEST);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {
            mCameraSource.stop();
        }
    });

    mBarcode.setProcessor(new Detector.Processor<Barcode>() {
        @Override
        public void release() {

        }

        @Override
        public void receiveDetections(Detector.Detections<Barcode> detections) {
            final SparseArray<Barcode> barcodes = detections.getDetectedItems();
            if (barcodes.size() > 0) {
                barkod.setText(barcodes.valueAt(0));           
            }
        }
    });
}