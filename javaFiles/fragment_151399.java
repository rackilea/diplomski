while(true){
  try {
    if (in.available() > 0) {                            
      msg = in.readLine();
      msg_parts = msg.split(" ");                         
      if (msg_parts[0].equals("CONNECTION")){
        Log.d("SocketService", "Broadcasting message");
        Intent intent = new Intent("ask.connection");
        intent.putExtra("nickname", msg_parts[1]);
        sendBroadcast(intent);
      }
    } else {
      Thread.sleep(100); // Or any sufficient delay.
    }
  } catch (IOException e) {
    e.printStackTrace();
  } catch (InterruptedException ie) {
    Thread.currentThread().interrupt();
    break;
  }
}