try {

        URL url = new URL("http://www.helpinghomelesscats.com/images/cat1.jpg");
        InputStream in = url.openConnection().getInputStream(); 
        BufferedInputStream bis = new BufferedInputStream(in,1024*8);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int len=0;
        byte[] buffer = new byte[1024];
        while((len = bis.read(buffer)) != -1){
            out.write(buffer, 0, len);
        }
        out.close();
        bis.close();

        byte[] data = out.toByteArray();
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        imageView.setImageBitmap(bitmap);
    }
    catch (IOException e) {
        e.printStackTrace();
    }