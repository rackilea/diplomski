if (PackageManager.PERMISSION_GRANTED == ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA))
        { 

            // asks primission to use the devices camera
            fragment = (BarcodeFragment)getSupportFragmentManager().findFragmentById(R.id.sample);
            fragment.setScanResultHandler(this);
            btn = ((Button)findViewById(R.id.scan));
            btn.setEnabled(false);

            // Support for adding decoding type
            fragment.setDecodeFor(EnumSet.of(BarcodeFormat.QR_CODE));

        } 
        else 
        {
            requestWritePermission(MainActivity.this);
        }