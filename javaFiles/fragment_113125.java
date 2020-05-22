private File SaveImage(Bitmap signature) {
        ContextWrapper root=new ContextWrapper(getApplicationContext());
        File Dir=root.getDir("profile",Context.MODE_PRIVATE);
        if(!Dir.exists()){
            Dir.mkdir();
        }
        String S_Name="Image_signature.jpg";
        File file=new File(Dir,S_Name);
        try {
            FileOutputStream outputStream= new FileOutputStream(file);
            signature.compress(Bitmap.CompressFormat.JPEG,100,outputStream);
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }