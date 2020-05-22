System.out.println("-----------------------");
System.out.println("MY APP");
System.out.println("-----------------------");
Console console = System.console();
int pinSize = 0;
int nbTry = 0;
boolean authenticated = false;

do {
   do {
      char passwordArray[] = console.readPassword("Enter pin: ");
      pinSize = passwordArray.length();

      if (pinSize != 4) {
     System.out.println("Pin must be 4 digits");
      } else {
     System.out.println("Checking...");
      }

      ArrayList<Integer> pins = new ArrayList<Integer>();
      readPinsData(new File("bdd.txt"), pins);
      // System.out.println(pins);
      // System.out.println(passwordArray);

      String[] thePins = new String[pins.size()];
      for (int i = 0; i < thePins.length; i++) {
         thePins[i] = pins.get(i).toString();
      }

      String passEntered = String.valueOf(passwordArray);

      for (int i = 0; i < thePins.length; i++) {
         if (passEntered.equals(thePins[i]) && pinSize == 4) {
    System.out.println(":)");
    authenticated = true;
    break;
}
}

} while (pinSize != 4);
  if (!authenticated && pinSize == 4) {
System.out.println(":(");
nbTry++;
 }
} while (nbTry < 3 && !authenticated);
}