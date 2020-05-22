byte[] bytes = Files.readAllBytes(sound.toPath());
AudioInputStream audioStream = AudioSystem.getAudioInputStream(
                                      new ByteArrayInputStream(bytes) 
                               );
Clip clip = AudioSystem.getClip();
clip.open(audioStream);