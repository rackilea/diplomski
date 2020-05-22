class SoundTest {
    static final int bufferLength = 44100;
    static final AudioFormat af8 = new AudioFormat(bufferLength, 8, 1, true, false);
    static final AudioFormat af16 = new AudioFormat(bufferLength, 16, 1, true, false);
    static volatile boolean go = true; //to be changed somewhere else

    static void startSound8(double[] hertz) {
        if (hertz.length == 0) {return;}
        try {
            SourceDataLine sdl = AudioSystem.getSourceDataLine(af8);
            sdl.open();
            sdl.start();
            int i = 0;
            //iterate as long as the sound must play
            do {
                //create a new buffer
                double[] buf = new double[128]; //arbitrary number
                final int startI = i;
                //iterate through each of the tones
                for (int k = 0; k < hertz.length; k++) {
                    i = startI;
                    //iterate through each of the samples for this buffer
                    for (int j = 0; j < buf.length; j++) {
                        double x = (double)i/bufferLength*hertz[k]*2*Math.PI;
                        double wave1 = Math.sin(x);
                        //decrease volume with increasing pitch
//                        double volume = Math.min(Math.max(300 - hertz[k], 50d), 126d);
                        double volume = 64;
                        buf[j] += wave1*volume;
                        i++;
                        if (i == 9999999) { //prevent i from getting too big
                            i = 0;
                        }
                    }
                }

                final byte[] finalBuffer = new byte[buf.length];
                //copy the double buffer into byte buffer
                for (int j = 0; j < buf.length; j++) {
                    //divide by hertz.length to prevent simultaneous sounds
                    //    from becoming too loud
                    finalBuffer[j] = (byte)(buf[j]/hertz.length);
                }

                //play the sound
                sdl.write(finalBuffer, 0, finalBuffer.length);
            } while (go);
            sdl.flush();
            sdl.stop();
            synchronized (SoundTest.class) {
                SoundTest.class.notifyAll();
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    static void startSound16(double[] hertz) {
        if (hertz.length == 0) {return;}
        try {
            SourceDataLine sdl = AudioSystem.getSourceDataLine(af16);
            sdl.open();
            sdl.start();
            int i = 0;
            //iterate as long as the sound must play
            do {
                //create a new buffer
                double[] buf = new double[128]; //arbitrary number
                final int startI = i;
                //iterate through each of the tones
                for (int k = 0; k < hertz.length; k++) {
                    i = startI;
                    //iterate through each of the samples for this buffer
                    for (int j = 0; j < buf.length; j++) {
                        double x = (double)i/bufferLength*hertz[k]*2*Math.PI;
                        double wave1 = Math.sin(x);
                        //decrease volume with increasing pitch
                        // double volume = Math.min(Math.max(300 - hertz[k], 50d), 126d);
                        double volume = 16384;
                        buf[j] += wave1*volume;
                        i++;
                        if (i == 9999999) { //prevent i from getting too big
                            i = 0;
                        }
                    }
                }

                final byte[] finalBuffer = new byte[buf.length * 2];

                //copy the double buffer into byte buffer
                for (int j = 0; j < buf.length; j++) {
                    //divide by hertz.length to prevent simultaneous sounds
                    //    from becoming too loud

                    int a = (int) (buf[j] / hertz.length);
                    finalBuffer[j * 2] = (byte) a;
                    finalBuffer[(j * 2) + 1] = (byte) (a >>> 8);
                }

                //play the sound
                sdl.write(finalBuffer, 0, finalBuffer.length);
            } while (go);
            sdl.flush();
            sdl.stop();
            synchronized (SoundTest.class) {
                SoundTest.class.notifyAll();
            }
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    static void playTone(final double hz, final boolean fewBits) {
        go = true;
        new Thread() {
            @Override
            public void run() {
                if (fewBits) {
                    startSound8(new double[] {hz});
                } else {
                    startSound16(new double[] {hz});
                }
            }
        }.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException x) {
            x.printStackTrace();
        } finally {
            go = false;
            synchronized (SoundTest.class) {
                try {
                    SoundTest.class.wait();
                } catch (InterruptedException x) {
                    x.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        playTone(220, true);
        playTone(220, false);
    }
}