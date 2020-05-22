Room r;
    do
    {
    Scanner dimensionsInput = new Scanner(System.in);
    System.out.print("Please enter the dimensions of the room, length, width and height accordingly");

    double roomLength = dimensionsInput.nextDouble();
    double roomWidth = dimensionsInput.nextDouble();
    double roomHeight = dimensionsInput.nextDouble();

    r = new Room(roomName, roomLength, roomWidth, roomHeight);
    }
    while (r.getLength() > 0 || r.getWidth() > 0 || r.getHeight() > 0);