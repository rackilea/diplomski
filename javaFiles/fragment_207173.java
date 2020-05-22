public void onActivityResult(int requestCode, int resultCode, Intent data) {
            // Result code is RESULT_OK only if the user selects an Image
            super.onActivityResult(requestCode, resultCode, data);
            if (resultCode == Activity.RESULT_OK) {
                if (requestCode == GALLERY_REQUEST_CODE) {
                    if (URI_REQUEST_CODE == 1) {
                        Uri selectedImage = data.getData();
                        if (selectedImage != null) {
                            Toast.makeText(this, selectedImage.toString(), Toast.LENGTH_SHORT).show();
                            Log.i("UriFromGalleryPicture", "onActivityResult: " + selectedImage.toString());
                        }
                    } else if (URI_REQUEST_CODE == 2) {
                        if (checkPermissionREAD_EXTERNAL_STORAGE(this)) {
                            Toast.makeText(this, uri.toString(), Toast.LENGTH_SHORT).show();
                            Log.i("UriFromCameraPicture", "onActivityResult: " + uri);
                    }
                }