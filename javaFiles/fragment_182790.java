private class TareaLeer extends Thread
{
    @Override
    public void run()
    {
        while(SocketBT.isConnected())
        {
        InputStream inputStream;
        try {
            inputStream = SocketBT.getInputStream();

            byte[] buffer = new byte[256];
            if (inputStream.available() > 0) {
                inputStream.read(buffer);
                int i = 0;
                for (i = 0; i < buffer.length && buffer[i] != 0; i++) {
                }
                String strInput = new String(buffer, 0, i);
                String Recepcion = strInput;

                Log.d("Recibi",Recepcion);
                //Here you can pass the value of recepcion to any globlal variable and show in TextView

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
    }
    Parar();
    }
}