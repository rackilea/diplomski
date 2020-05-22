try (Scanner scnr = new Scanner(System.in)) {
    do {
        System.out.println("Enter a name: ");
        name = scnr.nextLine();

        System.out.println("What type of animal is " + (name));
        type = scnr.nextLine();

        // change made here 
        pets.put(name, type);

        System.out.println("Would you like to enter another? (y/n) ");

        numberOfPets++;

      // here as well coz scanner was skipping the input
    } while (scnr.nextLine().equalsIgnoreCase("y")); 

}