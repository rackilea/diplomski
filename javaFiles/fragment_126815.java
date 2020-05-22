public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    int miles = 1;
    int gallons = 1;
    int totalMiles = 0;
    int totalGallons = 0;
    float mpg = 0;

    while (true) {
        System.out.println("Enter miles or -1 to exit");
        miles = input.nextInt();
        if (miles == -1) break;

        System.out.println("Enter gallons or -1 to exit");
        gallons = input.nextInt();
        if (gallons == -1) break;

        totalMiles = totalMiles + miles;
        totalGallons = totalGallons + gallons;
        mpg = (float) totalMiles / totalGallons;

        System.out.println(mpg);
    }
    input.close();
    System.out.print("Terminate");
}