public class DisplayWeekTempStat {
// Main method
public static void main(String[] args) {
    // Create a new scanner
    Scanner input = new Scanner(System.in);

    // Set array list
    int[] tempList = new int[7];

    // Prompt user for input and store input
    System.out.println("Enter the hightest temperature of each day for a week (starting on Sunday): ");
    for (int i = 0; i < tempList.length; i++)
        tempList[i] = input.nextInt();

    // Averages temperature
    double avgTemp = avgTemp(tempList);
    System.out.printf("The average temperature of the week is: %.2f degree %n", avgTemp);

    // Display hottest temperature
    int maxTemp = maxTemp(tempList);
    System.out.println("The highest temperature of the week is: " + maxTemp + " degree");

    // Display coldest temperature
    int minTemp = minTemp(tempList);
    System.out.println("The coldest temperature of the week is: " + minTemp + " degree");

    // Display hottest days of the week

    System.out.print("The hottest days of the week are: ");
    String[] tempMaxWeekDay = weekDay(maxTemp, tempList);
    for (int num = 0; num < tempMaxWeekDay.length; num++) {
        if (tempMaxWeekDay[num] != null)
            System.out.println(tempMaxWeekDay[num]);
    }

    // Display the coldest days of the week
    System.out.println("\n The coldest days of the week are: ");
    String[] tempMinWeekDay = weekDay(minTemp, tempList);
    for (int num = 0; num < tempMinWeekDay.length; num++) {
        if (tempMinWeekDay[num] != null)
            System.out.println(tempMinWeekDay[num]);
    }
}

// Average the temperature
public static double avgTemp(int[] array) {
    // Set a total temperature variable
    int tempTotal = array[0];

    // Add all temperature values
    for (int i = 1; i < array.length; i++)
        tempTotal = array[i] + tempTotal;

    // Return temperature average.
    return ((double) tempTotal / array.length);
}

// Get hottest temperature
public static int maxTemp(int[] array) {
    // Set hottest day variable
    int max = array[0];

    // Check and replace max temperature
    for (int i = 1; i < array.length; i++) {
        if (max < array[i])
            max = array[i];

    }
    return max;
}

// Get coldest temperature
public static int minTemp(int[] array) {
    // Set coldest day variable
    int min = array[0];

    // Check and replace coldtest temperature
    for (int i = 1; i < array.length; i++) {
        if (min > array[i])
            min = array[i];
    }
    return min;
}

public static String[] weekDay(int i, int[] array) {
    String[] maxWeekDays = new String[7];
    String[] weekDay = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
    int k = 0;
    for (int j = 0; j < weekDay.length; j++) {
        if (array[j] == i) {
            maxWeekDays[k] = weekDay[j];
            k++;
        }
    }
    return maxWeekDays;
}