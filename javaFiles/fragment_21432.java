if (wasd.equals("w")) {
    // swaps ground in front of you with you.
    ground[person.getX()][person.getY()] = ground[person.getX() - 1][person.getY()]; 
    // replaces you with ground above you.
    ground[person.getX() - 1][person.getY()] = person;
    person.setXandY(person.getX() - 1, person.getY());
    person.setDir("[ ^ ]");
}