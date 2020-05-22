package com.company;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Holds the list of all vehicles found in the file
        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        // Holds the data associated with the current vehicle being read
        ArrayList<String> currentVehicleData = new ArrayList<String>();

        // Java knowledge lacking here - not certain why I can't simply let the FNF exception bubble up
        Scanner file = null;
        try {
            file = new Scanner(new File("C:/Users/Timot/Desktop/vehiclesample.txt"));
        } catch(FileNotFoundException fnfe) {
            // Do something with this exception
            return;
        }

        String line;
        while(file.hasNextLine()) {
            // Get next line
            line = file.nextLine();

            // Next line is empty, so currentVehicleData has all the data associated the current vehicle
            if(line.isEmpty()) {
                vehicles.add(GetVehicle(currentVehicleData));
                currentVehicleData = new ArrayList<String>();
            }

            // Still reading data for the current vehicle
            else {
                currentVehicleData.add(line);
            }
        }

        // Add final vehicle
        vehicles.add(GetVehicle(currentVehicleData));

        file.close();
    }

    public static Vehicle GetVehicle(ArrayList<String> properties)
    {
        String vehicleType = properties.get(0);
        switch(vehicleType) {
            case "foreign car":
                return new ForeignCar(properties);
            case "truck":
                 return new Truck(properties);
            case "vehicle":
                 return new Vehicle(properties);
            case "bicycle":
                 return new Bicycle(properties);
            case "american car":
                 return new AmericanCar(properties);
            case "car":
                 return new Car(properties);
            default:
                throw new NotImplementedException();
        }
    }
}