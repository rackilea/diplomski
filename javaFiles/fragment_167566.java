String room = null;
boolean invalid = true;
while(invalid)
{
    System.out.println("What is the room number of your class?");
    room = kb.nextLine();
    roomnos = new Scanner(new File("/*file location*/"));
    while(roomnos.hasNext())
    {
        String roomno = roomnos.nextLine();
        if(room.equals(roomno))
            invalid = false;
    }
    if(invalid == true)
    {
        System.out.println("The room number you've given is invalid.");
    }
    roomnos.close();
}