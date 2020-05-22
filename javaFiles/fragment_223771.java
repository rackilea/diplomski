public void SendImage(){
    try {
        InetAddress address = InetAddress.getByName(ServerIP);
        clientSocket = new Socket(address, 3000);
        ObjectOutputStream oos = new ObjectOutputStream(clientSocket.getOutputStream());
        bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.image);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        byte[] compressedImage = baos.toByteArray();
        oos.writeObject(compressedImage);
        oos.flush();
        ObjectInputStream ois = new ObjectInputStream(clientSocket.getInputStream());
        String respond = (String)ois.readObject();
        Log.d("ObjectInputStream", respond);            
        oos.close();
        ois.close();
    } catch (Exception e) {
        Log.e("SendImage", e.toString());
    }

}