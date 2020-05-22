public ReadingThread readThread;
public int localPORT = 12345;

public void startReadingThread(){
    if (readThread == null || (!readThread.isAlive())){
        try {
            //define the socket but with null value
            listener = new DatagramSocket(null);
            listener.bind(new InetSocketAddress(localPORT));
            readThread = new ReadingThread();
            readThread.start();
        }
        catch (Exception ex)
        {
            System.out.println(ex.toString());
            return ex.getMessage();
        }
    }
}
public void stopReadingThread(){
    //stop the thread
    if (readThread != null && (readThread.isAlive()))
    {
        readThread.stop();
        readThread = null;
    }
    //disconnect the socket
    if (listener != null){
        listener.disconnect();
        listener.close();
    }
}
public class ReadingThread extends Thread {
    public void stop(){
        continue = false;
    }
    public boolean continue = true;
    public void run() {
        while(continue)
        {
            try
            {
                final String readingFeed = receiveData(listener);
                if (readingFeed != null){
                    //execute next code on main Thread (UI update, etc)
                    runOnUiThread(new Runnable() {
                        public void run()
                        {
                            //do something with the data received
                        }
                    });
                }
            }
            catch(Exception ex)
            {
                //showToast("Receiving Error: " + ex.toString());
                //continue = false;
            }
        }
    }
}
public String[] receiveData(DatagramSocket socket)
{
    try
    {
        byte[] buf = new byte[padre.configAdmin.buffer_size];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        String data = new String(packet.getData());
        return data;
    } catch (SocketTimeoutException e) {
        return null;
    } catch (IOException e) {
        return new String[] {"IOError: " + e.getMessage()};
    } catch (Exception e) {
        return new String[] {"ExError: " + e.getMessage()};
    }
}