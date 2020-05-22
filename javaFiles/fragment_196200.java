Ora base = hours.get(0);
System.out.println("Base: " + base + "\n");        

for (int i = 0; i < 4; i++) {

    System.out.println("First: " + base);
    Ora newOra = new Ora (...); // consider having a copy constructor that
                                // would accept base and copy its data
    // add code to update newOra to contain the same data as base

    // decreasing 60 minutes from hour
    newOra.decrementaMinuti(60);

    System.out.println("After: " + newOra);
    hours.add(0, newOra); // add the new instance