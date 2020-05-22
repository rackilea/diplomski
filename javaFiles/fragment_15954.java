while(!micMute)
        {
            int totalRead = 0, dataRead;
            while(totalRead < WAVBUFFERSIZE)
            {//although unlikely to be necessary, buffer the mic input
                dataRead = wavRecorder.read(wavbuffer, totalRead, WAVBUFFERSIZE - totalRead);
                totalRead = totalRead + dataRead;
            }
            int encodeLength = AmrEncoder.encode(AmrEncoder.Mode.MR122.ordinal(), wavbuffer, amrbuffer);