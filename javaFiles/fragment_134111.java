package lowesttemperature;

import java.net.URL;
import java.util.Scanner;


public class LowestTemperature
{
    public static void main( String[] args) throws Exception
    {
        double[] temps = arrayFromUrl("http://learnjavathehardway.org/txt/avg-daily-temps-atx.txt");

        System.out.println( temps.length + " tempatures in database.");

        double highest = -1, lowest = 9999.99; 
        Scanner input = new Scanner(System.in); 

        for ( int i = 0; i<temps.length; i++)
        {
            if ( temps[i] < lowest ) 
            {
                lowest = temps[i];
            }
            if ( temps[i] > highest)
            {
                highest = temps[i];
            }
        }

        System.out.print( "The lowest average daily tempature was ");
        System.out.println( lowest + "F (" + fToC(lowest) + "C)" );
        System.out.print( "The highest average daily tempature was ");
        System.out.println( highest + "F (" + fToC(highest) + "C)" ); 

        double term = searchTerm();
        for (int i = 0; i<temps.length; i++)
        {
            if(temps[i] == term){
                System.out.println("The term you searched for is at position " + i + " in the array"); 
            }
        }
    }

    public static double[] arrayFromUrl( String url ) throws Exception
    {
        Scanner fin = new Scanner((new URL(url)).openStream());
        int count = fin.nextInt();

        double[] dubs = new double[count];

        for ( int i = 0; i<dubs.length; i++)
            dubs[i] = fin.nextDouble();
        fin.close();

        return dubs;
    }

    public static double searchTerm(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a double: "); 
        double input = scan.nextDouble();
        return input;
    }

    public static double fToC( double f)
    {
        return (f-32)*5/9;
    }
}