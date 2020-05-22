public static void main(String args[]) {

    PersonLocation pl1 = new PersonLocation();
    PersonLocation pl2 = new PersonLocation();
    PersonData pd1 = new PersonData();
    PersonData pd2 = new PersonData();

    PersonLocation[] personLocation = new PersonLocation[2];
    PersonData[] personData = new PersonData[2];

    personLocation[0] = pl1;
    personLocation[1] = pl2;
    personData[0] = pd1;
    personData[1] = pd2;

    for (PersonLocation pl : personLocation) {
        System.out.println(pl);
    }

    for (PersonData pd : personData) {
        System.out.println(pd);
    }

}