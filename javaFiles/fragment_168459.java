usbDeviceConnection = connection;
  usbDeviceConnection.claimInterface(usbInterfaceFound, true);

  usbDeviceConnection.controlTransfer(0x21, 0x22, 0x1, 0, null, 0, 0);



// queue a request on the interrupt endpoint
            request.queue(buffer, buffer.capacity());
            // wait for status event
            if(usbDeviceConnection.requestWait() == request)
            {
                // there is no way to know how many bytes are coming, so simply forward the non-null values

                for(int i = 0; i < buffer.capacity() && buffer.get(i) != 0 ; i++)
                {
                    // transform ascii (0-255) to its character equivalent and append
                    dataByte = Character.toString((char) buffer.get(i));
                    data +=dataByte;
                    Log.e(this.getClass().getSimpleName(), "Was not able to read from USB device, ending listening thread ----> "+ data);


                }
            }