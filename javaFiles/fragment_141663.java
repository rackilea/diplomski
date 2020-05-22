for(Farmer fruit : farmers1) {
    if(fruit.getName().equals(tempName)) {
        farmers1.add(fruit); //the only place where you add something, but it never gets executed
        break;
    }
}