import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    public static void main(String[] args) {
        Scanner read = null;

        try {
            // Replace the "..." below with actual path to your data file.
            read = new Scanner(new File("..."));
        } catch (FileNotFoundException e) {
            System.out.println("The file can't be opened");
            System.exit(0);
        }
        List<USCrimeData> crimeClasses = new ArrayList<>();

        while (read.hasNextLine()) {
            crimeClasses.add(new USCrimeData(read.nextLine()));
        }

        read.close();

        int initialPopulation = crimeClasses.get(0).getPopulation();
        System.out.println("initialPopulation: "+initialPopulation);
        int latestPopulation = crimeClasses.get(crimeClasses.size()-1).getPopulation();
        System.out.println("latestPopulation: "+latestPopulation);
        double percentGrowth = (double)(latestPopulation - initialPopulation) / initialPopulation * 100;

        System.out.println("percentGrowth: "+percentGrowth);
    }

}