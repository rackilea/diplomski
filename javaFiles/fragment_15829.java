Map<String, String> pets = Map.of("a", "lion", "b", "bear", "c", "cat");
      Scanner scnr = new Scanner(System.in);

      do {
         System.out.println("Enter one letter (or type END to quit): ");
         String userInput = scnr.nextLine();
         if (userInput.equalsIgnoreCase("end")) {
            break;
         }
         System.out.println(userInput + " is an " + pets.get(userInput));

      } while (true);