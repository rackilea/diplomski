void printStates(){
    int time = (60 / minute) + second; // To calculate total time into seconds
    double speed = distance / time;  //double as the result will be a decimal
    System.out.println("Distance: " + distance 
            + " Speed: " + speed +" Metres per second");
}