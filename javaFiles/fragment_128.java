if (data.getData() != null){
   try{
     Uri uri = data.getData();
     //Get file extension here.
     String filePath = getPath(YourActivity.this, uri);
     String fileExtension = getFileExtension(filePath);
     File file = new File(filePath);
    }catch(Exception e){
         e("Err", e.toString()+"");
    }
}