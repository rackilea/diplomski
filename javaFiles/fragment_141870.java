private class WriteOutSoundBytes implements Runnable
    {
        byte[] rawByte;
        public WriteOutSoundBytes(byte[] rawBytes)
        {
            rawByte = rawBytes;
        }
        @Override
        public void run() 
        {
            mLine.write(rawByte, 0, rawByte.length);
        }


    }