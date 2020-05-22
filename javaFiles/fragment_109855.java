private final int SevenDays = 7;
  private final int FourteenDays = 14;

  private void checkReservation() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("The Dates should be in the YYYY-MM-DD Format");
    System.out.println("Enter the first date");
    String firstDate = scanner.nextLine();
    try{
      LocalDate startDate = LocalDate.parse(firstDate);
      System.out.println("Enter the Second sate");
      String secondDate = scanner.nextLine();
      LocalDate endDate = LocalDate.parse(secondDate);

      checkIfStayAllowed(getDifferenceInDays(startDate, endDate));
    } catch (DateTimeParseException dateParseError){
      dateParseError.printStackTrace();
    }
  }

  private void checkIfStayAllowed(int reservation){
    System.out.println(reservation);
    if(reservation == SevenDays){
      System.out.println("Guest is allowed to stay for 7 days");
    } else if (reservation ==FourteenDays){
      System.out.println("Guest is allowed to stay for 14 days");
    }
    // More logic can go here...
    else {
      System.out.println("Guest are only allowed to stay for 7 or 14 days!!!");
    }
  }

  private int getDifferenceInDays(LocalDate startDate, LocalDate endDate){
    return endDate.compareTo(startDate);
  }