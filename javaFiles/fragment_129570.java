if(requestCode == TAKE_IMAGE ){
        try {

                bitmap = (Bitmap) data.getExtras().get("data");
           // bitmap = MediaStore.Images.Media.getBitmap( getApplicationContext().getContentResolver(),  capturedImageUri);


            YourImageViewObject.setImageBitmap(bitmap);
            } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            } 


    }


    super.onActivityResult(requestCode, resultCode, data);
}