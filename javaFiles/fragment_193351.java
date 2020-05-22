public static ArrayList<Double> BelowAverage(ArrayList<Double> Averages) {
    // You already have a method for calculating the average, so use it
    double avg = CalculateAverages(Averages);
    ArrayList<Double> aveless = new ArrayList<Double>();
    int i;
    for(i = 0; i < Averages.size(); i++){
        double number = Averages.get(i);
        if(number < avg){
            aveless.add(number);
        }
    }
    return aveless;
}