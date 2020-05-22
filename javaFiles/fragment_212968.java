public class MyInputProcessor implements InputProcessor {
   @Override
   public boolean touchDown (int x, int y, int pointer, int button) {
      if (button == Input.Buttons.LEFT) {
          // Some stuff
          return true;     
      }
      return false;
   }
}