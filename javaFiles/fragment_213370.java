ArrayList<Person<Vehicle>> persons = new ArrayList<Person<Vehicle>>();
    // ...
    Person<Vehicle> personA = persons.get(0);
    ArrayList<Vehicle> vs = new ArrayList<Vehicle>();
    //vs.add(carA);    
    personA.setVehicles(vs);