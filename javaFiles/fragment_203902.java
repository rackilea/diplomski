public class Main {
public static void main(String[] args){
    List<Car> list = new ArrayList<>(Arrays.asList(new Car("Nissan", "Black", "KL1", "4"),
            new Car("Ford", "Red", "LL0", "4")));

    String id = "KL1";
    list.removeIf(i -> i.getID().equals(id));
    list.forEach(System.out::println); // show the list after operation
}

static class Car {
    public final String Brand;
    public final String Colour;
    public final String ID;
    public final String Door;

    public Car(String brand, String colour, String ID, String door) {
        Brand = brand;
        Colour = colour;
        this.ID = ID;
        Door = door;
    }

    public String getBrand() {
        return Brand;
    }

    public String getColour() {
        return Colour;
    }

    public String getID() {
        return ID;
    }

    public String getDoor() {
        return Door;
    }
}

}