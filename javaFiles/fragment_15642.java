try {
   choiceofcake = Integer.parseInt(userinput);
   if (choiceofcake > 5 || choiceofcake < 1) {
        break;
   }
} catch (NumberFormatException ee) {
    ee.printStatckTrace ();
    continue;
}