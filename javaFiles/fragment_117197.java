public class Player {

    private ArrayList<Item> newInvTest = new ArrayList<>();

    private String name;

    private int currentLevel;

    public String getName(){
        return name
    }

    public int getCurrentLevel(){
        return currentLevel
    }

    public ArrayList<Item> getInventory(){
        return newInvTest;
    }

}