for(int i = 0; i < deletePeople.size(); i++){
    Person display = deletePeople.get(i);
    if(display.equals(checkPerson)){
        System.out.println((display.getFirstName() + " " + display.getLastName() + " " + i));
    }
}