private float timeSinceLastLetter = 0f;
private static final float TIME_PER_LETTER = 100f;

public void render(float deltaTime) {
   // do your other rendering

   if(timeSinceLastLetter > TIME_PER_LETTER) {
       timeSinceLastLetter = 0f;
       // render your next letter here
   } else {
       timeSinceLastLetter += deltaTime;
   }
}