private static final int PIC = 100;
private static final int LICENSE = 101;
private static final int ROAD_WORTHINESS = 102;
private static final int INSURANCE = 103;


buttonChoose.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showFileChooser(PIC);
    }
});

buttonChoose2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        showFileChooser(LICENSE);
    }
});

private void showFileChooser(int requestCode) {
    Intent intent = new Intent();
    intent.setType("image/*");
    intent.setAction(Intent.ACTION_GET_CONTENT);
    startActivityForResult(Intent.createChooser(intent, "Select Picture"), requestCode);
}


@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == RESULT_OK && data != null && data.getData() != null) {
        filePath = data.getData();
        Log.d(TAG, "filePath 1 >>" + filePath);

        try {
            bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
            String myTag = data.getStringExtra("flg");

            Log.d(TAG, "myTag >>" + myTag);

            switch(requestCode) {
                case PIC:
                    imageView.setImageBitmap(bitmap);
                    break;
                case LICENSE:
                    imageViewLicense.setImageBitmap(bitmap);
                    break;
                case ROAD_WORTHINESS:
                    imageViewRoadWorthiness.setImageBitmap(bitmap);
                    break;
                case INSURANCE:
                    imageViewInsurance.setImageBitmap(bitmap);
                    break;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
````````