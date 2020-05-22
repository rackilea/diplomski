ArrayList<City> places = new ArrayList<>();
//Fill array

ArrayList<String> uniquePlaces = new ArrayList<>();
for (City city : places){
    if (!uniquePlaces.contains(city.getPlace())){
        uniquePlaces.add(city.getPlace());
    }
}

//number of unique places:
int uniqueCount = uniquePlaces.size();