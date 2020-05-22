// class
class StateRainfall {
    String[] states;
    double rainAmt[]; //declare array value entered by user
    int num_state; //number of states in west malaysia

    public StateRainfall(String[] states, double rain[]) {
        this.states = states;
        rainAmt = rain;
        num_state = states.length;
    }
}