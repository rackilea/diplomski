import java.io.*;

class Vehicle {
    private String vehicleNo;
    private String model;
    private String manufacturer;
    private String color;

    public void setNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getNo() {
        return vehicleNo;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}

class Truck extends Vehicle
{
    private double loadingCapacity;

    public void setLoad(double loadingCapacity) {
        this.loadingCapacity = loadingCapacity;
    }

    public double getLoad() {
        return this.loadingCapacity;
    }

}

public class VehicleInfo {

    private static void updateColorAndCapacity(BufferedReader br, Truck truck)
        throws IOException
    {
        System.out.print("Color: ");
        String col = br.readLine();
        truck.setColor(col);

        while (true)
        {
            System.out.print("Enter Loading Capacity (maximum 100tons):");
            String value = br.readLine();
            value = value.trim();
            try {
                int load = Integer.parseInt(value);
                truck.setLoad(load);
                return;
            } catch (NumberFormatException e) {
                /// do it once again
                continue;
            }
        }
    }

    public static void main(String[] args) 
        throws IOException {

        Truck truck = new Truck();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Vehicle No: ");
        String no = br.readLine();
        truck.setNo(no);

        System.out.print("Model: ");
        String model = br.readLine();
        truck.setModel(model);

        System.out.print("Manufacturer: ");
        String man = br.readLine();
        truck.setManufacturer(man);

        updateColorAndCapacity(br, truck);

        int loop_option = 0;        
        do {
            System.out.println();
            System.out.println("----Vehicle Information----");
            System.out.println();
            System.out.println("Vehicle No: " + truck.getNo());
            System.out.println("Model: " + truck.getModel());
            System.out.println("Manufacturer: " + truck.getManufacturer());
            System.out.println("Color: " + truck.getColor());
            System.out.println("Loading Capacity: " + truck.getLoad());
            System.out.println();
            System.out.println(" if U want to update color and loading capacity press 1 and to exit press 2 ..");

            loop_option = Integer.parseInt(br.readLine());

            if (loop_option == 1) {
                updateColorAndCapacity(br, truck);
            }

        } while (loop_option == 1);
    }
}