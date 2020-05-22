public class Ruler {
   private Player player;

   public Ruler(Player player) {
      this.player = player;
   }

    // **** this shouldn't be static!
    public void checkState(){
        // Player r = new Player();
        // System.out.print(r.getUsername() + "@root:~ > ");
        System.out.print(player.getUsername() + "@root:~ > ");
    }
}