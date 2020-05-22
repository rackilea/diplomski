boolean keepPlaying = true;
while(keepPlaying) {
  doNpcStep()
  doPlayerStep()
  keepPlaying = !isGameOver()
}