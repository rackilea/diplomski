ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>(){
                @Override
                public void onSuccess(Uri uri){


                    Toast.makeText(getApplicationContext(),"Image Loaded",Toast.LENGTH_SHORT).show();

                    //declare a global variable to contain the uri to 
                    //set in the drawable listener
                    globalDeclaredUri = uri;

                }
            });