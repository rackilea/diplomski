import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Automobile {

    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;

    //Here we will create a new automobile
    public Automobile(String make, String model, String color, int year, int
            mileage){
        this.make = make;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
    }
    //Here we create access to the make property
    public String getMake(){
        return make;
    }
    //Here we create access to the model property
    public String getModel(){
        return model;
    }
    ////Here we create access to the color property
    public String getColor(){
        return color;
    }
    //Here we create access to the year property
    public int getyear(){
        return year;
    }
    //Here we create access to the mileage property
    public int getMileage(){
        return mileage;
    }
    //Here we need to update the make property
    public void setMake(String make){
        this.make = make;
    }
    //Here we need to update the model property
    public void setModel(String model){
        this.model = model;
    }
    //Here we need to update the color property
    public void setColor(String color){
        this.color = color;
    }
    //Here we need to update the year property
    public void setYear(int year){
        this.year = year;
    }
    //Here we need to update the mileage property
    public void setMileage(int mileage){
        this.mileage = mileage;
    }
    //Not sure if this will work, String for printing as text
    @Override
    public String toString(){
        return "Automobile(" + "make=" + make + ", model=" + model + ", color="
                + color + ", year=" + year + ",mileage=" + mileage +'}';
    }
    //this is where the program hopefully manages the automobiles
    public static void main(String[] args) throws Exception{
        List<Automobile> autos = new ArrayList<>();
        Scanner in = new Scanner (System.in);

        //Menu is displayed for user
        while (true){
            System.out.println("Welcome to the vehicle inventory program, please make your selection");
                    System.out.println("1. Add a vehicle");
            System.out.println("2. Remove a vehicle");
            System.out.println("3. Update a vehicle");
            System.out.println("0. Exit");

            //Option selection
            System.out.println("Option: ");
            int option = Integer.parseInt(in.nextLine());
            //Process user selected option
            if (option == 1){
                //Add new vehicle option
                System.out.println("Make: ");
                String make = in.nextLine();

                System.out.println("Model: ");
                String model = in.nextLine();

                System.out.println("Color: ");
                String color = in.nextLine();

                System.out.println("Year: ");
                int year = Integer.parseInt(in.nextLine());

                System.out.println("Mileage: ");
                int mileage = Integer.parseInt(in.nextLine());

                Automobile auto = new Automobile
                        (make, model, color, year, mileage);
                autos.add(auto);
                System.out.println("Vehicle added!");
            }
            else if (option == 2 || option == 3){
                //user can select vehicle
                System.out.println("Please select a vehicle");

                for (int i = 0; i < autos.size(); i++){
                    System.out.println(i + " - " + autos.get(i));
                }
                System.out.print("Option: ");
                int selectVehicle = Integer.parseInt(in.nextLine());


                if (selectVehicle < 0 || selectVehicle >= autos.size()){
                    //confirm selected vehicle
                    System.out.println("Invalid Selection");
                }
                else if (option == 2){
                    //delete the selected vehicle
                    Automobile auto = autos.remove(selectVehicle);
                    System.out.println("Removed - " + auto);
                }
                else if (option == 3){
                    //update the selected vehcile
                    Automobile auto = autos.get(selectVehicle);
                    System.out.println("Updated Vehicle - " + auto);

                    System.out.print("Make: ");
                    auto.setMake(in.nextLine());

                    System.out.print("Model: ");
                    auto.setModel(in.nextLine());

                    System.out.print("Color: ");
                    auto.setColor(in.nextLine());

                    System.out.print("Year: ");
                    auto.setYear(Integer.parseInt(in.nextLine()));

                    System.out.print("Mileage: ");
                    auto.setMileage(Integer.parseInt(in.nextLine()));

                    System.out.println("Your vehicle is updated!");

                }
            }
            else if (option == 0){
                //Exit the program
                break;
            }
        }
        //write the vehicles to a file
        PrintWriter outFile = new PrintWriter(new FileWriter("vehcles.txt"));

        for (Automobile auto : autos){
            outFile.println(auto);
        }
        outFile.close();
        System.out.println("All Vehicle data has been written to vehicles.txt");

    }

}