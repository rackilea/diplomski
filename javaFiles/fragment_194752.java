public static void main(String[] args) throws Exception {
    String bridesName = "susan";
    String groomsName = "mike";
    int numberOfGuests = 12;
    double squareFootage = 12;
    ArrayList<String> namesOfSongs = new ArrayList<>();
    namesOfSongs.add("kkk");
    namesOfSongs.add("lll");
    namesOfSongs.add("iii");
    int guestsPerSquarefoot = 1;

    //add all the data to the text file
    try (PrintWriter dataToFile = new PrintWriter(new FileWriter("wedding.txt", true)))
    {
      dataToFile.println("Name of the bride: " + bridesName);
      dataToFile.println("Name of the groom: " + groomsName);
      dataToFile.println("Number of guests: " + numberOfGuests);
      dataToFile.println("Square footage of the location: " + (Double.toString(squareFootage)));

      //add songs to the text file
      for (String song : namesOfSongs)
      {
        dataToFile.println(song);
      }

      dataToFile.write("Number of guests per square footage: " + guestsPerSquarefoot);

      dataToFile.close();
    }

    try (Scanner scan = new Scanner (new File("wedding.txt"))) {
      while (scan.hasNextLine())
      {
        System.out.println(scan.nextLine());
      }
    }
  }