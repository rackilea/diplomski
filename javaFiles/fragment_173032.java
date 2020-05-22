public Cat extends Animal implements Enemy {
    //....
    public void getAction() {
        getMeow();  // call cat's specific action
    }
}

public Dog extends Animal implements Enemy {
    //....
    public void getAction() {
        getBark();  // call dogs's specific action
    }
}

public Submarine implements Enemy {
    // ....
    public void getAction() {
        // for sake of argument, let's just getX();
        getX();
    }
}