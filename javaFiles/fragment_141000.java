private searchImageFile() {
    Intent intent = new Intent(Intent.GET_CONTENT);

    // Filter to only show results that can be "opened"
    intent.addCategory(Intent.CATEGORY_OPENABLE);

    // Filter to show only images, using the image MIME data type.
    // it would be "*/*".
    intent.setType("image/*");

    startActivityForResult(intent, READ_REQUEST_CODE);
}

@Override
public void onActivityResult(int requestCode, int resultCode, Intent resultData) {

    if (requestCode == READ_REQUEST_CODE && resultCode == Activity.RESULT_OK) {

        final Uri imageUri = resultData.getData();
        //Do something with your Uri. 
    }
}