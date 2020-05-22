class Checker {
   private int x;
   private int y;
   private int id;
   private boolean white;
   private boolean king = false; // to clarify the default value

   public Checker(int x, int y, int id, boolean white) {
      this.x = x;
      this.y = y;
      this.id = id;
      this.white = white;
   }
   public boolean isKing() {
      return king;
   }
   public void setKing(boolean king) {
      this.king = king;
   }
   public int getX() {
      return x;
   }
   public int getY() {
      return y;
   }
   public int getId() {
      return id;
   }
   public boolean isWhite() {
      return white;
   }
}