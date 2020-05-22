int index = 0;
for (Person display : deletePeople) {
    if(display.equals(checkPerson)){
        System.out.println((display.getFirstName() + " " + display.getLastName() + " " + index));
    }
    index++;
}