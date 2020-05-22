Thread thread = new Thread() {

    @Override
    public void run() {



        while (true) {
            byte miastringacopy[] = {0X07, 0x3f, 0x01, 'b', 0x00, 0x08, 0x4f};
            byte miastringa1copy[] = {0X07, 0x3f, 0x01, 'b', 0x01, 0x08, 0x4e};
            byte miastringa2copy[] = {0X07, 0x3f, 0x01, 'b', 0x02, 0x08, 0x4d};
            byte miastringa3copy[] = {0X07, 0x3f, 0x01, 'b', 0x03, 0x08, 0x4c};

            if (co == 4) {

                co = 0;


                miastringa = miastringacopy;
                miastringa1 = miastringa1copy;
                miastringa2 = miastringa2copy;
                miastringa3 = miastringa3copy;
            }



            try {
                writeport();
                Thread.sleep(100);
                co++;


            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }
};


UsbSerialInterface.UsbReadCallback mCallback = new UsbSerialInterface.UsbReadCallback() { //Defining a Callback which triggers whenever data is read.
        @Override
        public void onReceivedData(byte[] readbuffer) {
            // Get the port input stream.

        byte readbuffer2[];
        readbuffer2 = new byte[20];

        // read data
        int numBytes = readbuffer.length;
        if(numBytes>=15) {


            for (i = 0; i < readbuffer.length; i++) {
                readbuffer2[i] = readbuffer[i];

            }
            if (co == 0) {

                for (i = 0; i < 8; i++) {
                    outputBuffer1[i] = readbuffer2[i + 6];

                }

            }

            if (co == 1) {
                for (i = 0; i < 8; i++) {
                    outputBuffer1[i + 8] = readbuffer2[i + 6];

                }


            }


            if (co == 2) {
                for (i = 0; i < 8; i++) {
                    outputBuffer2[i] = readbuffer2[i + 6];

                }


            }

            if (co == 3) {

                for (i = 0; i < 8; i++) {
                    outputBuffer2[i + 8] = readbuffer2[i + 6];

                }


            }