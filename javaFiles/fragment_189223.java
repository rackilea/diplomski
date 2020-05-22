//generate and set QR code
    ImageView imgQRCode = (ImageView) findViewById(R.id.imgQRCode);
    try {
        Bitmap qr = encodeAsBitmap("Any String HERE");

        if(qr != null)
            imgQRCode.setImageBitmap(qr);
        else {
            //Do whatever based on your logic
            //Toast.makeText(Prompt_ViewQRActivity.this, "Error message", Toast.LENGTH_LONG).show();
            //finish();
        }
    } catch (Exception e) {

    }