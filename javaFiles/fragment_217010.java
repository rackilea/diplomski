public class Place implements Comparable<Place> {
// the name of the place
private String name;
// invariant: name != null 

// Creates a new place with the given name.
public Place(String name){
if (name != null){
    this.name = name;   
} else 
    throw new NullPointerException();
}

//returns the name of a place
public String getName(){
    return name;
}

public int compareTo(Place other) {
    // do something here
}