public List<Lamborghini> getCarsFromThisYear(int year){
    List<Lamborghini> fromYear = new ArrayList<Lamborghini>();

    for( Lamborghini c : inventory){
        if(c.getModelYear() == year){
            fromYear.add(c);
        }
    }

    return fromYear;
  }