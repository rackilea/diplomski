private class SetupInterfacesRunnable implements Runnable
{
    @Override
    public void run()
    {
        synchronized(RadgetService.this)
        {
            usbManager = (UsbManager) getSystemService(Context.USB_SERVICE);
            usbConnection = usbManager.openDevice(usbDevice);

            /*
            interface :: id : 0, name : MTP, alt 0 [00ffh:00ffh:0000h] Vendor Specific
            interface :: id : 1, name : CDC Abstract Control Model (ACM), alt 0 [0002h:0002h:0001h] CDC Control
            interface :: id : 2, name : CDC ACM Data, alt 0 [000ah:0000h:0000h] CDC Data
            interface :: id : 3, name : Mass Storage, alt 0 [0008h:0006h:0050h] Mass Storage
             */

            // Interface 0 on the composite device is MTP
            MtpDevice mtpDevice = new MtpDevice(usbDevice);
            if (!mtpDevice.open(usbConnection)) {
                LoggerV2.e("Failed to obtain radget mtp storage");
            }
            else
            {
                LoggerV2.i("Opened MTP storage: %s", mtpDevice.getDeviceName());

                int[] storageIds = mtpDevice.getStorageIds();
                if (storageIds == null) {
                    LoggerV2.i("No mtp storage id's found");
                    return;
                }

                /*
                 * scan each storage
                 */
                for (int storageId : storageIds) {
                    LoggerV2.i("~~~~Storage id: %d~~~~", storageId);
                    scanObjectsInStorage(mtpDevice, storageId, 0, 0);
                }
            }

            // Interface 2 on the composite usb device is cdc acm data.
            serialPort = UsbSerialDevice.createUsbSerialDevice(usbDevice, usbConnection, 2);
            if(serialPort != null)
            {
                if(serialPort.open())
                {
                    serialPort.setBaudRate(115200);
                    serialPort.setDataBits(UsbSerialInterface.DATA_BITS_8);
                    serialPort.setParity(UsbSerialInterface.PARITY_NONE);
                    serialPort.setStopBits(UsbSerialInterface.STOP_BITS_1);
                    serialPort.setFlowControl(UsbSerialInterface.FLOW_CONTROL_OFF);

                    mUIHandler.post(notifyRadgetConnected);

                    // set the callback to catch serial data
                    serialPort.read(mCallback);

                    mUIHandler.post(handshake);

                }else
                {
                    // Serial port could not be opened, maybe an I/O error or it CDC driver was chosen it does not really fit
                    LoggerV2.e("Failed to open device serial port");
                }
            }else
            {
                // No driver for given device, even generic CDC driver could not be loaded
                LoggerV2.e("Failed to find driver for serial device");
            }

        }
    }
}