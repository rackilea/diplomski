mp.reset();
Random rand = new Random();
SONG_NUMBER = rand.nextInt((songs.size() - 1) - 0 + 1) + 0;
mp.setDataSource(SD_PATH + songs.get(SONG_NUMBER));
mp.prepare();   // Try this line
mp.start();