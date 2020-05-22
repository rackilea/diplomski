class Coordinates
{
private static int count = 0;
private int id=0;
private float xCoordinate;
private float yCoordinate;

public Coordinates()
{
    //Asks for input and assigns it to the two variables below
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Please enter the X Coordinate followed by the return key");
    xCoordinate = keyboard.nextDouble();
    System.out.println("Please enter the Y Coordinate followed by the return key");
    yCoordinate = keyboard.nextDouble();

    id=count++;
}

public getiD()
{
    return iD;
}

}