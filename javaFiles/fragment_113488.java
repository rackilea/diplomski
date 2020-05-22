public static void main(String[] args){

 ArrayList<City> cities = new ArrayList<City>();


 cities.add(new City(999,"NINE"));
 cities.add(new City(123,"COOL"));
 cities.add(new City(456,"FUN"));


 for(int i=0;i<cities.size();i++) {
     System.out.println(cities.get(i).getZipCode() + cities.get(i).getCityName());
 }

 Collections.sort(cities, (c1,c2) -> c1.getZipCode()-c2.getZipCode());
 System.out.println();

 for(int i=0;i<cities.size();i++) {
     System.out.println(cities.get(i).getZipCode() + cities.get(i).getCityName());
 }

 }