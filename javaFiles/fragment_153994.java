public void printWhatYouAre(Object o) {
    System.out.println(o.toString());
}

public void doingSomething() {
    Dog myDog = new Dog("Spike");
    Refrigerator myFridge = new Refrigerator();

    printWhatYouAre(myDog);
    printWhatYouAre(myFridge); //would print the same as above
}