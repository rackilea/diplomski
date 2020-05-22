Gallery g = (Gallery) findViewById(R.id.gallery);
// request only the image ID to be returned
String[] projection = {MediaStore.Images.Media._ID};
// Create the cursor pointing to the SDCard
cursor = managedQuery( MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
        projection, 
        MediaStore.Images.Media.DATA + " like ? ",
        new String[] {"%myimagesfolder%"},  
        null);
// Get the column index of the image ID
columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID);
g.setAdapter(new ImageAdapter(this));