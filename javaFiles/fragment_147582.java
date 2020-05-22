for(Iterator<Person> personIterator = persons.iterator(); i.hasNext(); ) {
    Person person = personIterator.next();
    for(Volcano volcano : volcanos) {
        if(volcano.getEruptionStatus() && 
           volcano.getYCoordVolcano() == person.getYCoordPerson() &&
           volcano.getXCoordVolcano() == person.getXCoordPerson()) {
               personIterator.remove();
        }
    }
}