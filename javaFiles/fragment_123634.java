public class Game {
     ....
     private Launcher l;

     public Game(Launcher l) {
        this.l = l;
        .....
     }

     public void dispose() {
         l.setChips(chipTotal);
         ....
     }
}