public class Room {

    private List<Window> windows = new ArrayList<Window>();
    private List<Wall> walls = new ArrayList<Wall>();
    private List<Door> doors = new ArrayList<Door>();

    public Room(int windows, int walls, int doors){
        for(int i=0; i < windows; i++)
            windows.add(new Window());
         //similarly for walls and Doors :)
    }

     //getters
}