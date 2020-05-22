AudioInputStream audioInput = AudioSystem.getAudioInputStream(songs[getRandomIntegerBetweenRange(0, 4)]);
    //Deleted this line:
    //Clip clip;
    //Changed this line:
    this.clip = AudioSystem.getClip();
    clip.open(audioInput);
    clip.start();
    clip.loop(clip.LOOP_CONTINUOUSLY);