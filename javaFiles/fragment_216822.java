if(fileIn.getName().endsWith(".ogg") || fileIn.getName().endsWith(".mp3")) {
  audioInputStream=createOggMp3(fileIn);
}
else { // wav
    audioInputStream=AudioSystem.getAudioInputStream(fileIn);
  }