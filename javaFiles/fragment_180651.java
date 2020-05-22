public class MovementAI {

private List<Gladiator> gladiators;

// Giving the class the list-reference, this list will be the same as the
// list in main, when main-list changes so does this one, they point to the
// same list-object, so the reference is only needed once.
public MovementAI(List<Gladiator> gladiatorsList) {
    this.gladiators = gladiatorsList;
}

// The class already has a reference to the list from its constructor so it
// doesn't need the list again as a parameter
public void moveAI() {

}

// If you don't want to keep a reference to the list in this class but only
// use it in a method (I would not recommend this)
public MovementAI() {

}

// You need to pass it gladiatorsList everytime you call this method.
public void moveAI(List<Gladiator> gladiators) {

}

}