class ChipCount{

      int chipCountPlayer;
      int chipCountComp;

    public ChipCount(int startChips){
      this.chipCountPlayer = startchips;
      this.chipCountComp = startchips;
    }
    public void setChips(int chipsToAdd, String player){
      if(player.equals("player")){
        this.chipCountPlayer = this.chipcountPlayer + chipsToAdd;
        } else if (player.equals("computer")){
          this.chipCountComp = this.chipcountComp + chipsToAdd;  
          }
      }
      public int getChips(String player){
      if(player.equals("player")){
      return chipCountPlayer;
      } else if (player.equals("computer")){
        return chipCountcomp;
        }
      }
  }