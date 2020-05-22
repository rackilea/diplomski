import javax.sound.midi.MidiDevice;
import javax.sound.midi.MidiMessage;
import javax.sound.midi.MidiSystem;
import javax.sound.midi.MidiUnavailableException;
import javax.sound.midi.Receiver;

public class MidiInputTest {

    public MidiDevice       input;
    public MidiDevice       output;

    public static void main(String[] args) {
        new MidiInputTest().start();
    } 


    public void start() {
        init();  // initialize your midi input device
                 // system dependent


        try {
            output.open(); // From midi device
            MyReceiver myrcvr = new MyReceiver();
            MidiSystem.getTransmitter().setReceiver(myrcvr);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

    private class MyReceiver implements Receiver  {
        Receiver rcvr;
        public MyReceiver() {
            try {
                this.rcvr = MidiSystem.getReceiver();
            } catch (MidiUnavailableException mue) {
                mue.printStackTrace();
            }
        }

        @Override
        public void send(MidiMessage message, long timeStamp) {
            byte[] b = message.getMessage();
            if (b[0] != (byte)254) {
                System.out.println((b[0] & 0xff) + " " + (b[1] & 0xff));
            }
            //rcvr.send(message, timeStamp); // will send out what ever you receive
        }

        @Override
        public void close() {
            rcvr.close();
        }
    } 
    public void init() {

        MidiDevice.Info[] devices;

        devices = MidiSystem.getMidiDeviceInfo();
        try{

            for (MidiDevice.Info info: devices) {
                MidiDevice device;
                device = MidiSystem.getMidiDevice(info);
                System.out.println("MidiDevice.Info="+info + "\n" + "maxTransmitters="+device.getMaxTransmitters());

                // I put the specific device I want to connect to behind an if gate here to avoid connecting to something I do not

                if (info.toString().equals("Interface [hw:2,0,0]") && device.getMaxTransmitters() != 0) { 
                    System.out.println(" Name: " + info.toString() +
                            ", Decription: " +
                            info.getDescription() +
                            ", Vendor: " +
                            info.getVendor());

                    output = MidiSystem.getMidiDevice(info);

                   if (! output.isOpen()) {
                        output.open();
                   }
                }
            }
        } catch (MidiUnavailableException mue) {
                    mue.printStackTrace();
        }
    }
}