if(mp.isPlaying())
    {  
        mp.stop();
    } 

    try {
        mp.reset();
        AssetFileDescriptor afd;
        afd = getAssets().openFd("AudioFile.mp3");
        mp.setDataSource(afd.getFileDescriptor(),afd.getStartOffset(),afd.getLength());
        mp.prepare();
        mp.start();
    } catch (IllegalStateException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }