public AlertStatus nextStatus(){
    int randNum = randNumGen.nextInt(3);
    switch(randNum){
        case 0: return new AlertStatusGreen();
        case 1: return new AlertStatusYellow();
        default: return new AlertStatusRed();
        // default: System.out.println("ERROR: no random number.");
    }
}