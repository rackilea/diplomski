private class myAsyncTask extends AsyncTask<File,Void,File>{

 @Override
    protected File doInBackground(File... voids) {
     File f = capturePicture();
     return f;
    }
    @Override
    protected  void onPostExecute(File f){

        String rr = f.getAbsolutePath();
        File g=new File(rr);
        Toast.makeText(postSharingActivity.this,"onBloodyClick: "+g.toString(),Toast.LENGTH_LONG).show();
        Uri uri = Uri.fromFile(g);
        Toast.makeText(postSharingActivity.this,"URI :"+uri.toString(),Toast.LENGTH_LONG).show();
        if(isStoragePermissionGranted()){
            savedImage.setImageURI(uri);
            cameraPreviewView.setVisibility(View.GONE);
            postCaptureView.setVisibility(View.VISIBLE);
        } else{
            Toast.makeText(postSharingActivity.this,"error",Toast.LENGTH_LONG).show();
        }

    } 
}