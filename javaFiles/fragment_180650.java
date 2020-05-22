public class Main {
// ....stuff
// This is the main class that keeps the list of gladiators
private List<Gladiator> gladiatorsList;
private Gladiator[] gladiatorsArray;
private MovementAI movementAI;

public Main() {
    // You initialize gladiatorsList and gladiatorsArray as before
    // gladiatorsList = ...
    // gladiatorsArrray = ...
    // Now you want to pass this list/array to another class (the AI), you
    // can do this in the constructor of that class like so:
    movementAI = new MovementAI(gladiatorsList);
}

// ...stuff as before

}