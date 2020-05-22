Button play36 = (Button)findViewById(R.id.threesix);
Button stop = (Button)findViewById(R.id.stop);

String[] listOfFiles = new String[0];
try {
    listOfFiles = getAssets().list("");
    final List<String> musicOnlyList = new ArrayList<>();

    for(int i = 0; i < listOfFiles.length; i++){
        if (getExtension(listOfFiles[i]).equals("mp3"))
            musicOnlyList.add(listOfFiles[i]);
    }

    final MediaPlayer mediaPlayer = new MediaPlayer();

    play36.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int itemIndex = new Random().nextInt(musicOnlyList.size());
            String file = musicOnlyList.get(itemIndex);
            AssetFileDescriptor afd = null;
            try {
                afd = getAssets().openFd(file);
                mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getLength());
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
            mediaPlayer.start();
        }
    });

    stop.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mediaPlayer.stop();
            try {
                mediaPlayer.prepare();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    });

} catch (IOException e) {
    e.printStackTrace();
}