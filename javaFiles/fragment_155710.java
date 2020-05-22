public String checkCursor(){
        String testString = null; 
       // ^^      ^^   
       //note the declaration of testString here!
        if(!filename.equals("234")){

        String[] proj = {MediaStore.Images.Media.TITLE};
        String selection = MediaStore.Images.Media.DATA + "='" + filename +"'";

        imageCursor = managedQuery(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,    proj, selection, null, MediaStore.Images.Media._ID );
        if( imageCursor != null ){
            if( imageCursor.moveToFirst() ){

       testString = (String) imageCursor.getString(imageCursor.getColumnIndex(MediaStore.Images.Media.IS_PRIVATE));

            }
        }

        }
        return testString;

        }