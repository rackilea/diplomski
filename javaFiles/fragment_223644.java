public class USBTransfertMain {

    public static void main(String[] args) throws Throwable {
        jMTPeMethode();
    }

    private static void jMTPeMethode() 
    {
        PortableDeviceFolderObject targetFolder = null;
        PortableDeviceManager manager = new PortableDeviceManager();
        PortableDevice device = manager.getDevices()[0];
        // Connect to USB tablet
        device.open();
        System.out.println(device.getModel());

        System.out.println("---------------");

        // Iterate over deviceObjects
        for (PortableDeviceObject object : device.getRootObjects()) 
        {
            // If the object is a storage object
            if (object instanceof PortableDeviceStorageObject) 
            {
                PortableDeviceStorageObject storage = (PortableDeviceStorageObject) object;

                for (PortableDeviceObject o2 : storage.getChildObjects()) 
                {
                    if(o2.getOriginalFileName().equalsIgnoreCase("testFolder"))
                    {
                        targetFolder = (PortableDeviceFolderObject) o2;
                    }

                    System.out.println(o2.getOriginalFileName());
                }

                copyFileFromComputerToDeviceFolder(targetFolder);
                PortableDeviceObject[] folderFiles = targetFolder.getChildObjects();
                for (PortableDeviceObject pDO : folderFiles) {
                    copyFileFromDeviceToComputerFolder(pDO, device);
                }

            }
        }

        manager.getDevices()[0].close();
    }

    private static void copyFileFromDeviceToComputerFolder(PortableDeviceObject pDO, PortableDevice device)
    {
        PortableDeviceToHostImpl32 copy = new PortableDeviceToHostImpl32();
        try {
            copy.copyFromPortableDeviceToHost(pDO.getID(), "C:\\TransferTest", device);
        } catch (COMException ex) {
            ex.printStackTrace();
        }

    }

    private static void copyFileFromComputerToDeviceFolder(PortableDeviceFolderObject targetFolder) 
    {
        BigInteger bigInteger1 = new BigInteger("123456789");
        File file = new File("C:\\GettingJMTP.pdf");
        try {
            targetFolder.addAudioObject(file, "jj", "jj", bigInteger1);
        } catch (Exception e) {
            System.out.println("Exception e = " + e);
        }
    }
}