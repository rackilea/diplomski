Ora base = hours.get(0); // this is the instance added multiple times
System.out.println("Base: " + base + "\n");        

for (int i = 0; i < 4; i++) {

    System.out.println("First: " + base);
    // decreasing 60 minutes from hour
    base.decrementaMinuti(60);

    System.out.println("After: " + base);
    hours.add(0, base); // here you add the same instance multiple times