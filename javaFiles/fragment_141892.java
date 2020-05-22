//you see rooms have walls, and many. So constructor takes List of 
//windows and doors in each wall. So, a List of walls that has List 
// (mixed bag) of windows and doors in each wall -- some may have no 
//window/door, then 2nd list will be empty.
public class Room {

    List<Wall> _walls = new ArrayList<Wall>();

    public Room(List<List<Openable>> walls){
        for(List<Openable> windowsOrDoors : walls){
            this._walls.add(new Wall(windowsOrDoors));
        }
    }
}

//wall can have many doors and/or windows. We pass out mixed 
// bag list here, constructor will figure out how to keep 
//them in separate lists
public class Wall {

    List<Door> doors = new ArrayList<Door>();
    List<Window> windows = new ArrayList<Window>();

    public Wall(List<Openable> openables){
        for(Openable windowsOrDoor : openables){
            if(windowsOrDoor instanceOf Window)
                this.windows.add(windowsOrDoors);
            else
                this.doors.add(windowsOrDoors);
        }
    }
}

//Window class, simple class -- it is of type Openable
public class Window implements Openable{
    public Window(int w, int h){
        //do something
    }
}

//Door class, simple class -- it is of type Openable
public class Door implements Openable{
    public Door(int w, int h){
        //do something
    }
}

//Openable -- a common interface to Window and Door, you can use 
//abstract class here and have getHeight, getWidth and other common 
//methods. This just for the purpose that if you wanted to add another 
//Window/Door class like `ArchedDoor` which has a `radius` as well, 
//you will just write a `ArchedDoor implements Openable` and pass into 
//the Room/Wall constructor. Nothing will break. 
public interface Openable{}