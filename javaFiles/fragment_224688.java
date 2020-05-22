public static void main(String[] args) {

        Scanner input = new Scanner(System.in); 
        System.out.print("How many cities? ");
        int number = input.nextInt();
        City [] cities = new City [number];
         for(int i = 0; i < number; i++){
            cities[i] = new City(); // create new object of City
            System.out.println("City # " + (i+1));
            System.out.print("Enter name: " );
            String name = input.next();
            cities[i].setName(name);
            System.out.print("Enter longitude: ");
            double longitude = input.nextDouble();
            cities[i].setLongitude(longitude);
            System.out.print("Enter latitude: ");
            double latitude = input.nextDouble();
            cities[i].setLatitude(latitude);
        }
}

public class City {

    private String name;      //name of cities
    private double lon, lat;  //longitude & latitude

    City(){  // default constructor
       name="";
       this.lon = 0;
       this.lat = 0;
    }

    City(String name, double lon, double lat) 
    {
        this.name = name;
        this.lon = lon;
        this.lat = lat;
    } 

    public void setName(String n){
         name = n;
    }
    public void setLongitude(double longitude){
         lon = longitude;
    }
    public void setLatitude(double latitude){
         lat = latitude;
    }
}