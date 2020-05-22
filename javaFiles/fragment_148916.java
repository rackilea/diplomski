alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "New", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialog, int which) {
            Intent takePictureIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uri);

            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    });