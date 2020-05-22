try(InputStream is = socket.getInputStream()){
    byte[] b = new byte[2048];// you can change the buffer's size.
    for(int r = 0; (r = is.read(b))!= -1;){
        for(OutputStream client : clients){
            client.write(b, 0, r);
        }
    }
}catch(Exception e){
    e.printStackTrace();
}