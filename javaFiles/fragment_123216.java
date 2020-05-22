static final int frequency = 44100;
    static final int channelConfiguration = AudioFormat.CHANNEL_CONFIGURATION_MONO;
    static final int audioEncoding = AudioFormat.ENCODING_PCM_16BIT;
    boolean isPlaying;
    int playBufSize;
    Socket socket;
    AudioTrack audioTrack;

    playBufSize=AudioTrack.getMinBufferSize(frequency, channelConfiguration, audioEncoding);
    audioTrack = new AudioTrack(AudioManager.STREAM_MUSIC, frequency, channelConfiguration, audioEncoding, playBufSize, AudioTrack.MODE_STREAM);

    new Thread() {
        byte[] buffer = new byte[4096];
        public void run() {
            try { 
                socket = new Socket(ip, port); 
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            audioTrack.play();
            isPlaying = true;
            while (isPlaying) {
                int readSize = 0;
                try { readSize = socket.getInputStream().read(buffer); }
                catch (Exception e) {
                    e.printStackTrace();
                }
                short[] sbuffer = new short[1024];
                for(int i = 0; i < buffer.length; i++)
                {

                    int asInt = 0;
                    asInt = ((buffer[i] & 0xFF) << 0) 
                            | ((buffer[i+1] & 0xFF) << 8) 
                            | ((buffer[i+2] & 0xFF) << 16) 
                            | ((buffer[i+3] & 0xFF) << 24);
                    float asFloat = 0;
                    asFloat = Float.intBitsToFloat(asInt);
                    int k=0;
                    try{k = i/4;}catch(Exception e){}
                    sbuffer[k] = (short)(asFloat * Short.MAX_VALUE);

                    i=i+3;
                }
                audioTrack.write(sbuffer, 0, sbuffer.length);
            }  
            audioTrack.stop();
            try { socket.close(); }
            catch (Exception e) { e.printStackTrace(); }
        }
    }.start();