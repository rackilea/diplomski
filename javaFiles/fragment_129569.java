//Global variable
private static final int TAKE_IMAGE = 2;


//OnClick of your button or whereever you want to start camera
   @Override
        public void onClick(View v) {


            Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);  
            startActivityForResult(cameraIntent, TAKE_IMAGE); 
       }

//onActivityREsul portion of your code