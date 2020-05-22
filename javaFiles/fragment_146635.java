public Car getBestSelection(List<Car> cars, String make, String model, String year){
    Map<Car, Integer> scoreMap = new HashMap<>(cars.size());

    // Find scores for all valid cars
    for(Car car : cars)
        if(isValidCar(car, make, model, year))
            scoreMap.push(car, calcScore(car, make, model, year));

    // find max score
    Car maxCar;
    int maxScore;
    for(Map.Entry<Car, Integer> e : scoreMap.entrySet()){
        if(e.getValue() > maxScore){
            maxScore = e.getValue();
            maxCar = e.getKey();
        }
    }

    return maxCar;
}

public int calcScore(Car car, String make, String model, String year){
    int makeScore  = car.make.equals(make)   ? Math.pow(2,2) : 0;
    int modelScore = car.model.equals(model) ? Math.pow(2,1) : 0;
    int yearScore  = car.year.equals(year)   ? Math.pow(2,0) : 0;

    return makeScore + modelScore + yearScore;
}

public boolean isValidCar(Car car, String make, String model, String year){
    return (car.make.equals("") && car.model.equals("") && car.year.equals("")) ||
           (car.make.equals(make) || car.model.equals(model) || car.year.equals(year));
}