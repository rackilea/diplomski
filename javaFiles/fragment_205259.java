int x = ...;
List<Rom> roomList = new  ArrayList<Rom> ();

for (int i=0; i<asManyAsIWant;i++){
    Room room = new Room();
    roomList.add(room);
}

if((x >= 0) && (x < roomList.size())    //Extra check to avoid ArrayIndexOutOfBoundsException
    roomList.get(x).doSomthing();
else
    //Do something when x is larger or smaller than it should be.