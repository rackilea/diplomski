String encodedString = "data:image/jpeg;base64,..."
    encodedString = encodedString.replace("data:image/jpeg;base64,","");
    byte[] image = Base64.decode(encodedString.getBytes(), 0);




    Bitmap bitmap = BitmapFactory.decodeByteArray(image, image.length);