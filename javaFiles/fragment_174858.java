scanButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (barcodeScanned) { // this if block never gets executed since barcodeScanned is false
                    barcodeScanned = false;
                    scanText.setText("Scanning...");
                    mCamera.setPreviewCallback(previewCb);
                    mCamera.startPreview();
                    previewing = true;
                    mCamera.autoFocus(autoFocusCB);

                    //------------- try 
                    Intent i = new Intent(CameraTestActivity.this, display.class);
                    startActivity(i);
                    //-------------


                }
            }
        });