public static void main(String[] args) {
    System.out.println(
            "This program is intended to convert a temperature from Celcius to Fahrenheit, and other way around.");
    int infiniteLoop = 0;
    int oneLimitLoop = 0;
    for (int x = 0; x < 1; x--) {

        // **System.out.println(infiniteLoop); // loop tester

        System.out.println("Is it is Celcius, or Fahrenheit");
        System.out.println("Please enter C/c frr celcius, or F/f for Fahrenheit");

        String tempType = scan.nextLine();
        //scan.nextLine();
        System.out.println("You may now enter the desisred temperature you would like to convert");

        int tempNumber = Integer.parseInt(scan.nextLine())

        if (tempType.equalsIgnoreCase("c")) {
            int celcius = tempNumber;
            int celciuscConverter = (9 * (celcius) / 5) + 32;
            System.out.println(celciuscConverter);
        } else if (tempType.equalsIgnoreCase("f")) {
            int fahrenheit = tempNumber;
            int farenheitConverter = 5 * (fahrenheit - 32) / 9;
            System.out.println(farenheitConverter);
        }

    }

}