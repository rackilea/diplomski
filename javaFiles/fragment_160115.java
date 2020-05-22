public class Building {

    static ArrayList<Building> Buildings = new ArrayList<Building>();
    private String color;
    private Object owner;
    private int cost;
    private int rent;
    private int location;
    private String name;

    //my constructor:
    public Building(String color, Object owner, int cost, int rent, int location, String name) {
            this.color = color;
            this.owner = owner;
            this.cost = cost;
            this.rent = rent;
            this.location = location;
            this.name = name;
            Buildings.add(this);// this should add the street into the ArrayList Buildings
        }

    public static void main(String[] args) {
         Building street1 = new Building("brown", 0, 60, 2, 1, "4th street");
         System.out.println(Building.Buildings.size());
    }   
}