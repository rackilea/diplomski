onClick(){
      firebaseImageUpload(filePath, Callback)
    }

    onUploaded(){
      // Display toast here
    }

ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
    @Override
    public void onSuccess(Uri uri) {
    URL = uri.toString(); 
    callback.onUploaded(URL);
    }
    });

     interface Callback{
       void onUploaded(String url)
     }