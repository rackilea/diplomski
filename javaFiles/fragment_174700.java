public void play(MediaPlayer mediaPlayer, Context context, String musicName) throws IOException {
        AssetFileDescriptor assetFileDescriptor = context.getAssets().openFd(musicName);
        mediaPlayer.setDataSource(assetFileDescriptor.getFileDescriptor(),
                assetFileDescriptor.getStartOffset(),
                assetFileDescriptor.getLength());
        mediaPlayer.prepare();
        mediaPlayer.start();
    }