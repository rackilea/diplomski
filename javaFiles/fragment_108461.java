public static void main(String[]args) throws Exception
{
    FileReader file = new FileReader("C:/Users/Aaron/Documents/java/car_file.txt");
    BufferedReader reader = new BufferedReader(file);
    List<Car> cars = new ArrayList<Car>();
    String line = reader.readLine();
    while (line!= null)
    {
        cars.add(new Car(line));
        line = reader.readLine();
    }
}

public class Car {
    private String type;
    private String brand;
    private String model;
    private int price;

    public Car(String spec) {
        String[] parts = spec.split(",");
        if (parts == null || parts.length != 4) {
            throw new IllegalArgumentException("Bad car specification: " + spec);
        }
        int i = 0;
        type = parts[i++];
        brand = parts[i++];
        model = parts[i++];
        price = Integer.parseInt(parts[i++]);
   }

   public int getPrice() {
        return price;
   }

   // other getters and setters could go here

   public String toString() {
       return String.format("Car type=%s, brand=%s, model=%s, price=%s", type, brand, model, price);
    }
}