public class GamePanel extends JPanel { ... your game here ... }
public class GameApplet extends JApplet {  
   private final GamePanel game;
   public GameApplect(GamePanel gamePanel) {
      this.game = game;
      super.add(game);
   }

   public void init() {
      ... applet init ... 
      this.game.init();
   }

   public void start() {
      ... applet start ...
      this.game.start(); 
   }
}

public class GameWindow extends JFrame {  
   private final GamePanel game;
   public GameApplect(GamePanel gamePanel) {
      this.game = game;
      super.add(game);
   }

   public void init() {
      ... frame init ... 
      this.game.init();
   }

   public void start() {
      ... frame start ...
      this.game.start(); 
   }
}