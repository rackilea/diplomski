public static void main(String[] args) {
    int[] temperature = new int[1];
    Scanner keyboard = new Scanner(System. in);
    readTemperatures(keyboard, temperature);
    int sum = getSum(temperature);
    int average = sum/temperature.length;
    System.out.println("The average temperature is: " + average); 
    int daysOver=getDaysOver(temperature, average);
    System.out.println("The temperature was above average for " 
                                                         + daysOver + " day(s).");
    sortTemperature(temperature);
    printTemperature(temperature);
 }