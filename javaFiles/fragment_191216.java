public class MyClass{
    private ArrayList<UUID> toggle = new ArrayList<>();

    public void toggleScoreboard(Player p){
        if (toggle.contains(p.getUniqueId()))
        // Rest of your code here
    }
}