double roomLength;
    double roomWidth;
    double roomHeight;
    do
    {
    Scanner dimensionsInput = new Scanner(System.in);
    System.out.print("Please enter the dimensions of the room, length, width and height accordingly");

    roomLength = dimensionsInput.nextDouble();
    roomWidth = dimensionsInput.nextDouble();
    roomHeight = dimensionsInput.nextDouble();

    Room r = new Room(roomName, roomLength, roomWidth, roomHeight);
    }
    while (roomLength > 0 || roomWidth > 0 || roomHeight > 0);