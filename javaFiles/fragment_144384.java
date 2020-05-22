public ArrayList<Lamborghini> getCarsFromThisYear(int year){
    ArrayList<Lamborghini> fromYear = new ArrayList<Lamborghini>();

    for( Lamborghini c : inventory){
        if(c.getModelYear() == year){
            fromYear.add(c);
        }
    }

    if( fromYear.size() == ZERO){
        return new ArrayList<>();
    }
    return fromYear;
  }