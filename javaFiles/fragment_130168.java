// Define a VERY simple interface with one method.

interface Shootable {
    public void beingShot();
}

// Any class that implements this interface can be treated interchangeably

class Revolver implements Shootable {
    public void beingShot() {
        System.out.println("Revolver: firing 1 round");
}

class MachineGun implements Shootable {
    public void beingShot() {
        System.out.println("Machine Gun: firing 50 rounds");
    }
}

class HockeyPuck implements Shootable {
    public void beingShot() {
        System.out.println("Hockey Puck: 80 MPH slapshot");
    }
}

class RayBourquePuck implements Shootable {
    public void beingShot() {
        System.out.println("Hockey Puck: 110 MPH slapshot");
    }
}

class OunceOfWhiskey implements Shootable {
    public void beingShot() {
        System.out.println("Whiskey Shot: 1 oz down the hatch...");
    }
}

// You can declare an array of objects that implement Shootable

Shootable[] shooters = new Shootable[4];

// You can store any Shootable object in your array:

shooters[0] = new MachineGun();
shooters[1] = new Revolver();
shooters[2] = new HockeyPuck();
shooters[3] = new OunceOfWhiskey();

// A Shootable object can reference any item from the array

Shootable anyShootableItem;

// The same object can to refer to a MachineGun OR a HockeyPuck

anyShootableItem = shooters[0];
anyShootableItem.beingShot();

anyShootableItem = shooters[2];
anyShootableItem.beingShot();

// You can call beingShot on any item from the array without casting

shooters[0].beingShot();
shooters[1].beingShot();

// Let's shoot each object for fun:

for (Shootable s : shooters) {
    s.beingShot();
}