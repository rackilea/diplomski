public double earnings(){
    double adjustedHours = hours;
    // For hours over 40, add 1/2 time to make it 1 1/2 time total
    if (hours >= 40){
        adjustedHours = adjustedHours + 0.5 * (hours - 40)
    }
    return adjustedHours * wage;
}