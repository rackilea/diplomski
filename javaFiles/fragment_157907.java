public class Items
{
    private HashMap<String, Double> Hallway = new HashMap<String, Double>();
    private HashMap<String, Double> Toilet = new HashMap<String, Double>();
    ...

    public HashMap<String, Double> getHallwayItems() 
    {
       return Hallway;        
    }
    ...
    ...

    public static void main (String args[])
    {
        Items myItem = new Items();
         myItem.getHallwayItems(); // and do whatever you want.
    }
}