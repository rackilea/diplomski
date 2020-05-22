public static void main(String[] args) {
      Scanner scanner = new Scanner (System.in);
      System.out.println("Please enter a model:");
      String model = scanner.nextLine(); // validate if you need to
      System.out.println("please enter a make");
      String make = scanner.nextLine();  // validate if you need to
      CarTest carOne = new CarTest(make,model); // pass the entered details to the carOne object
      System.out.println(carOne.getMake()); // will display the value of make that has been entered
}