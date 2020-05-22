public class Hotel1 {
private int numberOfRooms1;// number of rooms
Person rooms[];



public Hotel1(int numberOfRooms1){    //the constructor
    this.numberOfRooms1=numberOfRooms1;
    Person[]rooms=new Person[numberOfRooms1];
    this.rooms=rooms;
}


//Private method to check if the array has an empty place

private boolean isEmpty(){
    boolean isEmpty =false;
    for (int i=0;i<rooms.length;i++){
        if (rooms[i]==null){
            return true;
        }
    }
    return isEmpty;

}

//Check in
public Person[] checkIn(Person person){
    if (isEmpty()){
    for (int i=0;i<rooms.length;i++){
        if (rooms[i]==null){
            rooms[i]=person;
            return rooms;
        }
        else continue;
    }
    }
    else {
        System.out.println("There is rooms left for "+person.getFirstName()+" Sorry!");
    }
    return rooms;
}}