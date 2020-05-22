public class House {

    public Address addressOfHouse;
    public Room bedroom;
    public Room childrenroom;
    public Room kitchen;
    public Room livingroom;
    public Room lobby;
    public Room workroom;
    private ArrayList<Room> rooms;

    public House (){
        addressOfHouse=new Address();

        rooms = new ArrayList<>();

        bedroom=new Room();
        rooms.add(bedroom);
        childrenroom=new Room();
        rooms.add(childrenroom);
        kitchen=new Room();
        rooms.add(kitchen);
        livingroom=new Room();
        rooms.add(livingroom);
        lobby=new Room();
        rooms.add(lobby);
        workroom=new Room();
        rooms.add(workroom);
    }

    public double totalArea (int floor){
        double totalArea=0.0;

        for (Room room : rooms) {
            if (room.getFloor() == floor)
                totalArea += room.getArea();
        }

        return totalArea;
    }

    public double totalArea (){
        return totalArea(1);
    }

}