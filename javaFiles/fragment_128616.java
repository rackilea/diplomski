public class Ranks extends JavaPlugin implements Listener{
     public boolean isAdmin(String playerName){
        //rest of business logic
     }
}


public class CustomInventory implements Listener{
    private Ranks rank;

    public CustomInventory(Ranks rank) {
       this.rank = rank;
    } 


   //then call this.rank.isAdmin as usual
}