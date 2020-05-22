public static String[] wineTypes = {"Riesling", "Chardonnay", "Sauvignon Blanc", "Merlot"};
  public static String[][] wineVariations = {
    {"Dry- $4.50", "Off Dry-$4.00", "Sweet- $5.00"},
    {"Apple- $6.00", "Lemon-$5.50", "Vanilla- $6.00"},
    {"Lime-$4.50", "Lemongrass- $6.50", "Coconut- $7.00"},
    {"Plum- $5.00", "Black Cherry- $7.50", "Chocolate- $6.00"}
  };

  public static void main(String[] args) {
    do {
      String wineType = (String) JOptionPane.showInputDialog(null,
              "Select wine type:",
              "Input - Wine Type - (Column)",
              JOptionPane.QUESTION_MESSAGE,
              null,
              wineTypes,
              wineTypes[0]);
      if (wineType == null) {
        System.out.println("NULL!");
      } else {
        System.out.println(wineType);
      }
      /*
      Do "the same" for the variations within the selected type.
      Tip: If you can use ArrayLists instead of Arrays, it will make it a lot easier to get the indexes of the choices...
      ...This, in turn, would make the second loop, and the processing of the prices, much easier...
      ...Just be careful with the last rule in your assignment; make sure it was covered, or don't use it.
      Tip: You will need a loop to get the correct array of options...
      ...And you'll need to contain that loop within a function, and return only the result, in order to use it as parameter to the JOptionPane.
      */
      /*
      Except for the main loop, I left the handling of the "cancel" buttons to you as well.
      */
    } while (JOptionPane.showConfirmDialog(null, "Continue?", "Input - Continue", JOptionPane.YES_NO_OPTION) == 0);
  }