import java.util.Scanner;

class TestRoom
{
    public static void main(String[] args)
    {
        Scanner userInput = new Scanner(System.in);
        String roomName = "";

        while (!(roomName.equals("quit")))
        {
            System.out.println("Please enter the name of room");

            roomName = userInput.next();

            Room r;

            do
            {
                System.out
                        .print("Please enter the dimensions of the room, length, width and height accordingly");

                double roomLength = userInput.nextDouble();
                double roomWidth = userInput.nextDouble();
                double roomHeight = userInput.nextDouble();

                r = new Room(roomName, roomLength, roomWidth, roomHeight);
            } while (r.getLength() == 0 || r.getWidth() == 0
                    || r.getHeight() == 0);

            System.out.println("The name of room: " + r.getName()
                    + " Dimensions: L= " + r.getLength() + " X " + "W= "
                    + r.getWidth() + " X " + "H= " + r.getHeight());
            System.out.println("Area of room= " + r.getArea());
            System.out.println("Volume of room= " + r.getVolume());
        }

        userInput.close();
    }
}