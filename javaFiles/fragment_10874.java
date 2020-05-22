Predicate<CarObj> predColor2 = Predicates.compose(predColor , 
   new Function<CarObj, String>() {
     @Override public String apply(CarObj car) {
       return car.getColor();
     }
   });