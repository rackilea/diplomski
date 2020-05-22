//class declaration, public means it is visible to other classes in this project.
public class CD {
    private String title; //this is a field, it is private bc you don't want this to 
                          //be accessed by anything else, for encapsulation reasons
    private String artist; //this is a string bc I'm assuming it is a word or words
    private int numOfTracks; //this is an int bc you can't have 4.5 tracks
    private float cost; //this is float bc I'm assuming there are decimals

    //this is the constructor, it says that it requires the arguments in the () to construct
    //this constructor just sets the fields, and constructor always has the same name as the class
    //you have to use "this" keyword bc the local variable names parameters are
    //the same as the global variables, and will take precedence. this is called "hiding"
    //"this" lets it know that you are referring to the global variable
    //you can avoid having to do this by just having diff names.
    public CD(String title, String artist, int numOfTracks, float cost) {
        this.title = title;
        this.artist = artist;
        this.numOfTracks = numOfTracks;
        this.cost = cost;
    }

    //accessor method example. this method has return type of String
    //bc you want to return the title
    public String getTitle() {
        return title; //just allows looking at the title, not changing it
    }

    //other methods and stuff
    //...
}

//to construct a CD object in another class somewhere:
CD allstar = new CD("Allstar", "Smashmouth", 1, 500f);

//based on how we defined the CD constructor, you are creating a CD where the
//first argument is the title, "Allstar"
//second argument is artist, "Smashmouth"
//third argument is numOfTracks, 1, bc this cd only has one song on it and
//fourth argument is cost, 500, bc this song is very expensive and highly sought after