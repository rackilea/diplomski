public class SaveTraffic extends SwingWorker<Void, String> {

  public GUI f = new GUI();

  @Override
  public Void doInBackground() throws IOException {

     // some code

     publish(captor.getPacket().toString());

     // the method below is calling sendPacket on the background thread
     // which then calls showPackets on the background thread
     // which then appends text into the JTextArea on the background thread
     //sendPacket(captor.getPacket().toString());

     return null;
  }

  @Override
  protected void process(List<String> packetTextList) {
     for (String packetText : packetTextList) {
        sendPacket(packetText); //edit, changed to match your code
     }
  }

  @Override
  public void done() {
     System.out.println("I am DONE");

  }

  public void sendPacket(String Packet) {

     f.showPackets(Packet);
  }
}