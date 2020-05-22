public class DistanceofCities {



public static void main(String[] args) {

    int [][] distance = {
            {0, 171, 115, 141, 240},
            {171, 0, 103, 194, 333},
            {115, 103, 0, 120, 235},
            {141, 194, 120, 0, 104},
            {240, 333, 235, 104, 0}

    };

    int mileage;
    int first = -1, second = -1;
       Scanner keyboard= new Scanner(System.in);
       System.out.println("To determine the mileage between cities, enter the \n");
       System.out.println("numbers of two cities from the following list:\n");
       System.out.println("      1:  Albany           4:  NY\n");
       System.out.println("      2:  Boston           5:  Phila\n");
       System.out.println("      3:  Hartford\n\n");
       System.out.println("Enter your city numbers ==> ");
       first = keyboard.nextInt();
       second = keyboard.nextInt();
       mileage = distance[first-1][second-1];
       System.out.println("The distance between your two cities is "+ mileage);
    }
}