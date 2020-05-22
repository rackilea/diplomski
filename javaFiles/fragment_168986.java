mFactory = new MediaPlayerFactory();
    mPlayer = mFactory.newHeadlessMediaPlayer();

    String mrl = "rtsp://@" + addressStr + ":" + mPhoneRTSPPort;

    String options = ":sout=#transcode{vcodec=h264,venc=x264{cfr=16},scale=1,acodec=mp4a,ab=160,channels=2,samplerate=44100}"
            + ":file{dst=C:/Users/the man/yahoo.mp4}";

    mPlayer.playMedia(mrl, options);