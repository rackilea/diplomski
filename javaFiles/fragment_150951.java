import be.derycke.pieter.com.COMException;
import be.derycke.pieter.com.Guid;
import java.io.*;
import java.math.BigInteger;
import jmtp.PortableDevice;
import jmtp.*;

public class Jmtp {

    public static void main(String[] args) {
        PortableDeviceManager manager = new PortableDeviceManager();
        PortableDevice device = manager.getDevices()[0];
        // Connect to my mp3-player
        device.open();

        System.out.println(device.getModel());

        System.out.println("---------------");

        // Iterate over deviceObjects
        for (PortableDeviceObject object : device.getRootObjects()) {
            // If the object is a storage object
            if (object instanceof PortableDeviceStorageObject) {
                PortableDeviceStorageObject storage = (PortableDeviceStorageObject) object;

                for (PortableDeviceObject o2 : storage.getChildObjects()) {
//                    
//                        BigInteger bigInteger1 = new BigInteger("123456789");
//                        File file = new File("c:/JavaAppletSigningGuide.pdf");
//                        try {
//                            storage.addAudioObject(file, "jj", "jj", bigInteger1);
//                        } catch (Exception e) {
//                            //System.out.println("Exception e = " + e);
//                        }
//                    

                    System.out.println(o2.getOriginalFileName());
                }
            }
        }

        manager.getDevices()[0].close();

    }
}