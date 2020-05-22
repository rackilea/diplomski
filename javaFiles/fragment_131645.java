public void play(Film song) {
    try {
        Clip sound = AudioSystem.getClip();

        sound.open(AudioSystem.getAudioInputStream(new File(song.getClip())));

        sound.start();

    } catch (Exception e) {
        System.out.println("Whatever" + e);
    }
  }
}