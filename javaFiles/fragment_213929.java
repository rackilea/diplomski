public static void main (String args[]) {

    PersonLocation pl1 = new PersonLocation();
    PersonLocation pl2 = new PersonLocation();
    PersonData pd1 = new PersonData();
    PersonData pd2 = new PersonData();

    Object[] array = new Object[4];
    array[0] = pl1;
    array[1] = pd1;
    array[2] = pl2;
    array[3] = pd2;

    for(Object o : array){
        if(o instanceof PersonLocation){
            PersonLocation tempPersonLocation = (PersonLocation) o;
            System.out.println(tempPersonLocation);
        }
        if(o instanceof PersonData){
            PersonData tempPersonData = (PersonData) o;
            System.out.println(tempPersonData);
        }
    }


}