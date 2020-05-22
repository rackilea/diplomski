public class AirlineSystem
{
  public AirlineSystem()
  {
    final String[][] seats = initializeSeats(18, 10);
    displaySeatingArrangement(seats);
  }

  private String[][] initializeSeats(final int ROWS, final int COLUMNS)
  {
    final String[][] seats = new String[ROWS][COLUMNS];
    int seatIndex = 1;

    for (int i = 0, ch = 'a'; i < ROWS; i++, ch++)
    {
      for (int j = 0; j < COLUMNS; j++)
      {
        seats[i][j] = (seatIndex++) + "" + (char) ch;
      }
    }

    return seats;
  }

  private void displaySeatingArrangement(final String[][] seats)
  {
    System.out.println("Plane Seating Arrangement: ");

    for (String[] row : seats)
    {
      for (String seat : row)
      {
        System.out.printf(" %4s ", seat);
      }

      System.out.println();
    }
  }

  public static void main(String[] args)
  {
    new AirlineSystem();
  }
}