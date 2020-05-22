public static int roundWeirdly(double value){
    if (value - (int) value >= 0.6){
        return (int) value  + 1;
    } else {
        return (int) value;
    }
}