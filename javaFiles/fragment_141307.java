import java.util.*; 

public class Database {

public Database () {

}

public static int numberOfSpawnpoints = 0;
static Scanner userInput = new Scanner(System.in);

public static void main(String[] args) {

    System.out.println("Add a new spawnpoint.\n");

    System.out.println("State the name of this spawnpoint: ");
    ArrayList<Spawnpoints> SPlist = new ArrayList<Spawnpoints>();

    SPlist.add(new Spawnpoints(getSpawnName())); 
    // the above line will create an object of Spawnpoints and store it in  list

    System.out.println("Name: " + SPlist.get[0].getSpawnName());
    System.out.println("Location: " + SPlist.get[0].getLocation());
    System.out.println("Pokemon: " + SPlist.get[0].getPokemon());
    System.out.println("Spawntime: " + SPlist.get[0].getSpawntime()); 

    System.out.println("The pokemon is currently spawned: " + SPlist.get[0].isSpawned());

    numberOfSpawnpoints++;

}

public static String spawnName;

public static String getSpawnName() {

    spawnName = userInput.next();
    return spawnName;
}

public void setSpawnName(String spawnName) {

    Database.spawnName = spawnName;
}

}