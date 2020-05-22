public abstract class Monster{
    public void fight(){
        // your method that you define
    }

    // this method has to be overridden in children classes
    public abstract void fight(Player p, List<String> inventory);
}