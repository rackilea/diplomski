@Override
    public void run(){
        short[] lin = new short[SIZE_OF_RECORD_ARRAY];
        int num = 0;
        record.startRecording();
        track.play();
        while (passThroughMode) {
            num = record.read(lin, 0, SIZE_OF_RECORD_ARRAY);
            for(i=0;i<lin.length;i++)
                lin[i] *= WAV_SAMPLE_MULTIPLICATION_FACTOR; 
            track.write(lin, 0, num);
        }
    }